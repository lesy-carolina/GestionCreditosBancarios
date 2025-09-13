package org.nttdata.com.serviciotransacciones.service.impl;

import lombok.RequiredArgsConstructor;
import org.nttdata.com.serviciotransacciones.dto.TransaccionRequest;
import org.nttdata.com.serviciotransacciones.dto.TransaccionResponse;
import org.nttdata.com.serviciotransacciones.exception.ResourceNotFound;
import org.nttdata.com.serviciotransacciones.model.Transaccion;
import org.nttdata.com.serviciotransacciones.repository.TransaccionRepository;
import org.nttdata.com.serviciotransacciones.service.TransaccionService;
import org.nttdata.com.serviciotransacciones.util.TransaccionMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransaccionServiceImpl implements TransaccionService {
    private final TransaccionRepository transaccionRepository;
    private final TransaccionMapper transaccionMapper;

    @Override
    public List<TransaccionResponse> getAllTransacciones() {
        return transaccionMapper.toDtoList(transaccionRepository.findAll());
    }

    @Override
    public TransaccionResponse getTransaccionById(Long id) {
        return transaccionMapper.toDto(transaccionRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Transaccion no encontrada con id: " + id)
        ));
    }

    @Override
    public TransaccionResponse createTransaccion(TransaccionRequest transaccionRequest) {
        return transaccionMapper.toDto(transaccionRepository.save(
                transaccionMapper.toEntity(transaccionRequest)
        ));
    }

    @Override
    public TransaccionResponse updateTransaccion(Long id, TransaccionRequest transaccionRequest) {
        Transaccion transaccionFound = transaccionRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Transaccion no encontrada con id: " + id)
        );
        transaccionFound.setCuentaId(transaccionRequest.getCuentaId());
        transaccionFound.setTipoTransaccion(transaccionMapper.toEntity(transaccionRequest).getTipoTransaccion());
        transaccionFound.setMonto(transaccionRequest.getMonto());
        transaccionFound.setFecha(transaccionRequest.getFecha());
        transaccionFound.setReferencia(transaccionRequest.getReferencia());

        return transaccionMapper.toDto(transaccionRepository.save(transaccionFound));
    }

    @Override
    public void deleteTransaccion(Long id) {
        Transaccion transaccionFound = transaccionRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Transaccion no encontrada con id: " + id)
        );
        transaccionRepository.delete(transaccionFound);
    }
}
