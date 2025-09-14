package org.nttdata.com.servicioprestamos.service.impl;

import feign.FeignException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.nttdata.com.servicioprestamos.client.ClienteClient;
import org.nttdata.com.servicioprestamos.client.TransaccionClient;
import org.nttdata.com.servicioprestamos.client.dto.ClienteResponse;
import org.nttdata.com.servicioprestamos.client.dto.TransaccionResponse;
import org.nttdata.com.servicioprestamos.dto.PrestamoRequest;
import org.nttdata.com.servicioprestamos.dto.PrestamoResponse;
import org.nttdata.com.servicioprestamos.exception.BadRequest;
import org.nttdata.com.servicioprestamos.exception.ResourceNotFound;
import org.nttdata.com.servicioprestamos.models.Prestamo;
import org.nttdata.com.servicioprestamos.repository.PrestamoRepository;
import org.nttdata.com.servicioprestamos.service.PrestamoService;
import org.nttdata.com.servicioprestamos.util.PrestamoMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PrestamoServiceImpl implements PrestamoService {
    private final PrestamoRepository prestamoRepository;
    private final PrestamoMapper prestamoMapper;
    private final ClienteClient clienteClient;
    private final TransaccionClient transaccionClient;

    private static final String CLIENTE_SERVICE_CB = "clienteService";


    @Override
    public List<PrestamoResponse> getAllPrestamos() {
        return prestamoMapper.toDtoList(prestamoRepository.findAll());
    }

    @Override
    public PrestamoResponse getPrestamoById(Long id) {
        return prestamoMapper.toDto(prestamoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Préstamo no encontrado con id: " + id)));
    }

    @Override
    public Prestamo getPrestamoEntityById(Long id) {
        return prestamoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Préstamo no encontrado con id: " + id)
        );
    }

    @Override
    @CircuitBreaker(name = CLIENTE_SERVICE_CB, fallbackMethod = "createPrestamoFallback")
    public PrestamoResponse createPrestamo(PrestamoRequest prestamoDto) {

        //Verificar existencia del cliente
        ClienteResponse clienteResponse;
        try{
            clienteResponse = clienteClient.getClienteById(prestamoDto.getClienteId());
            if(clienteResponse == null || clienteResponse.getId() == null){
                throw new ResourceNotFound("El cliente con id: " + prestamoDto.getClienteId() + " no existe");
            }
        } catch (FeignException.NotFound ex){
            throw new ResourceNotFound("El cliente con id: " + prestamoDto.getClienteId() + " no existe");
        }

        //Verificacion existencia de cuenta




        //Evaluar credito
        evalularCredito(prestamoDto.getCuentaId(), prestamoDto.getMonto());

        //Generar prestamo


        return prestamoMapper.toDto(prestamoRepository.save(prestamoMapper.toEntity(prestamoDto)));
    }

    public void evalularCredito(Long cuentaId, BigDecimal montoSolicitado){
        List<TransaccionResponse> transaccionRealizdas = transaccionClient.obteTransacciones(cuentaId);
        BigDecimal ingresos = transaccionRealizdas.stream()
                .filter(t -> t.getTipoTransaccion().getNombre().equalsIgnoreCase("DEPÓSITO"))
                .map(TransaccionResponse::getMonto)
                .reduce(BigDecimal.ZERO, BigDecimal::add);


        BigDecimal egresos = transaccionRealizdas.stream()
                .filter(t -> {
                    String tipo = t.getTipoTransaccion().getNombre().toUpperCase();
                    return tipo.equalsIgnoreCase("RETIRO")
                            || tipo.equalsIgnoreCase("PAGO DE SERVICIO")
                            || tipo.equalsIgnoreCase("TRANSFERENCIA");
                })
                .map(TransaccionResponse::getMonto)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal capacidadPago = ingresos.multiply(new BigDecimal("0.3"));

        if(egresos.compareTo(ingresos.multiply(new BigDecimal("1.1"))) > 0){
            throw new BadRequest("El cliente no cumple con los requisitos para el préstamo porque sus egresos son mayores a sus ingresos");
        } else if(montoSolicitado.compareTo(capacidadPago) > 0){
            throw new BadRequest("El cliente no cumple con los requisitos para el préstamo su maximo es: " + capacidadPago);
        }
    }

    public PrestamoResponse createPrestamoFallback(PrestamoRequest prestamoDto, Throwable ex) {
        throw new RuntimeException("El servicio de clientes no está disponible. Intente más tarde" + ex);
    }

    @Override
    @CircuitBreaker(name = CLIENTE_SERVICE_CB, fallbackMethod = "createPrestamoFallback")
    public PrestamoResponse updatePrestamo(Long id, PrestamoRequest prestamoDto) {
        Prestamo prestamoFound = prestamoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Préstamo no encontrado con id: " + id)
        );

        //Verificar existencia del cliente
        ClienteResponse clienteResponse;
        try{
            clienteResponse = clienteClient.getClienteById(prestamoDto.getClienteId());
            if(clienteResponse == null || clienteResponse.getId() == null){
                throw new ResourceNotFound("El cliente con id: " + prestamoDto.getClienteId() + " no existe");
            }
        } catch (FeignException.NotFound ex){
            throw new ResourceNotFound("El cliente con id: " + prestamoDto.getClienteId() + " no existe");
        }

        prestamoFound.setClienteId(prestamoDto.getClienteId());
        prestamoFound.setCuentaId(prestamoDto.getCuentaId());
        prestamoFound.setMonto(prestamoDto.getMonto());
        prestamoFound.setPlazoMeses(prestamoDto.getPlazoMeses());
        prestamoFound.setTasaInteres(prestamoDto.getTasaInteres());
        prestamoFound.setEstadoPrestamo(prestamoMapper.toEntity(prestamoDto).getEstadoPrestamo());
        prestamoFound.setFechaDesembolso(prestamoDto.getFechaDesembolso());
        return prestamoMapper.toDto(prestamoRepository.save(prestamoFound));
    }

    @Override
    public void deletePrestamo(Long id) {
        Prestamo prestamoFound = prestamoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Préstamo no encontrado con id: " + id)
        );
        prestamoRepository.delete(prestamoFound);
    }
}
