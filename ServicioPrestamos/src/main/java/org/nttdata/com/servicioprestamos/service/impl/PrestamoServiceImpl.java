package org.nttdata.com.servicioprestamos.service.impl;

import feign.FeignException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.nttdata.com.servicioprestamos.client.ClienteClient;
import org.nttdata.com.servicioprestamos.client.dto.ClienteResponse;
import org.nttdata.com.servicioprestamos.dto.PrestamoRequest;
import org.nttdata.com.servicioprestamos.dto.PrestamoResponse;
import org.nttdata.com.servicioprestamos.exception.ResourceNotFound;
import org.nttdata.com.servicioprestamos.models.Prestamo;
import org.nttdata.com.servicioprestamos.repository.PrestamoRepository;
import org.nttdata.com.servicioprestamos.service.EstadoPrestamoService;
import org.nttdata.com.servicioprestamos.service.PrestamoService;
import org.nttdata.com.servicioprestamos.util.EstadoPrestamoMapper;
import org.nttdata.com.servicioprestamos.util.PrestamoMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PrestamoServiceImpl implements PrestamoService {
    private final PrestamoRepository prestamoRepository;
    private final PrestamoMapper prestamoMapper;
    private final EstadoPrestamoMapper estadoPrestamoMapper;
    private final ClienteClient clienteClient;
    private final EstadoPrestamoService estadoPrestamoService;

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


        //Evaluacion credito

        //Generar prestamo


        Prestamo prestamo = prestamoMapper.toEntity(prestamoDto);
        prestamo.setEstadoPrestamo(estadoPrestamoService.getEstadoPrestamoEntityById(prestamoDto.getEstadoPrestamoId()));
        return prestamoMapper.toDto(prestamoRepository.save(prestamo));
    }

    public PrestamoResponse createPrestamoFallback(PrestamoRequest prestamoDto, Throwable ex) {
        throw new RuntimeException("El servicio de clientes no está disponible. Intente más tarde" + ex);
    }

    @Override
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
        prestamoFound.setEstadoPrestamo(estadoPrestamoService.getEstadoPrestamoEntityById(prestamoDto.getEstadoPrestamoId()));
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
