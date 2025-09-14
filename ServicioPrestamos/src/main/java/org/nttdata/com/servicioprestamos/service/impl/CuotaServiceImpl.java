package org.nttdata.com.servicioprestamos.service.impl;

import lombok.RequiredArgsConstructor;
import org.nttdata.com.servicioprestamos.dto.CuotaRequest;
import org.nttdata.com.servicioprestamos.dto.CuotaResponse;
import org.nttdata.com.servicioprestamos.exception.ResourceNotFound;
import org.nttdata.com.servicioprestamos.models.Cuota;
import org.nttdata.com.servicioprestamos.repository.CuotaRepository;
import org.nttdata.com.servicioprestamos.service.CuotaService;
import org.nttdata.com.servicioprestamos.util.CuotaMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CuotaServiceImpl implements CuotaService {
    private final CuotaRepository cuotaRepository;
    private final CuotaMapper cuotaMapper;

    @Override
    public List<CuotaResponse> getAllCuotas() {
        return cuotaMapper.toDtoList(cuotaRepository.findAll());
    }

    @Override
    public CuotaResponse getCuotaById(Long id) {
        return cuotaMapper.toDto(cuotaRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Cuota no encontrada con id: " + id)
        ));
    }

    @Override
    public CuotaResponse pagarCuota(Long id, Long cuentaId) {

        //Realizar meotdo pagar cuota
        return null;
    }

    @Override
    public CuotaResponse saveCuota(CuotaRequest cuotaRequest) {
        return cuotaMapper.toDto(cuotaRepository.save(cuotaMapper.toEntity(cuotaRequest)));
    }

    @Override
    public CuotaResponse updateCuota(Long id, CuotaRequest cuotaRequest) {
        Cuota cuotaEntityRequest = cuotaMapper.toEntity(cuotaRequest);

        Cuota cuotaFound = cuotaRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Cuota no encontrada con id: " + id)
        );
        cuotaFound.setPrestamo(cuotaEntityRequest.getPrestamo());
        cuotaFound.setNumero(cuotaRequest.getNumero());
        cuotaFound.setMonto(cuotaRequest.getMonto());
        cuotaFound.setFechaVencimiento(cuotaRequest.getFechaVencimiento());
        cuotaFound.setMonto(cuotaRequest.getMonto());
        cuotaFound.setEstadoCuota(cuotaEntityRequest.getEstadoCuota());

        return cuotaMapper.toDto(cuotaRepository.save(cuotaFound));
    }

    @Override
    public void deleteCuota(Long id) {
        Cuota cuotaFound = cuotaRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Cuota no encontrada con id: " + id)
        );
        cuotaRepository.delete(cuotaFound);

    }
}
