package org.nttdata.com.servicioprestamos.service.impl;

import lombok.RequiredArgsConstructor;
import org.nttdata.com.servicioprestamos.dto.CuotaRequest;
import org.nttdata.com.servicioprestamos.dto.CuotaResponse;
import org.nttdata.com.servicioprestamos.exception.ResourceNotFound;
import org.nttdata.com.servicioprestamos.models.Cuota;
import org.nttdata.com.servicioprestamos.repository.CuotaRepository;
import org.nttdata.com.servicioprestamos.service.CuotaService;
import org.nttdata.com.servicioprestamos.service.EstadoCuotaService;
import org.nttdata.com.servicioprestamos.service.PrestamoService;
import org.nttdata.com.servicioprestamos.util.CuotaMapper;
import org.nttdata.com.servicioprestamos.util.EstadoCuotaMapper;
import org.nttdata.com.servicioprestamos.util.PrestamoMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CuotaServiceImpl implements CuotaService {
    private final CuotaRepository cuotaRepository;
    private final CuotaMapper cuotaMapper;
    private final EstadoCuotaMapper estadoCuotaMapper;
    private final PrestamoMapper prestamoMapper;
    private final EstadoCuotaService estadoCuotaService;
    private final PrestamoService prestamoService;

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
        Cuota cuota = cuotaMapper.toEntity(cuotaRequest);
        cuota.setEstadoCuota(estadoCuotaService.getEstadoCuotaEntityById(cuotaRequest.getEstadoCuotaId()));
        cuota.setPrestamo(prestamoService.getPrestamoEntityById(cuotaRequest.getPrestamoId()));

        return cuotaMapper.toDto(cuotaRepository.save(cuota));
    }

    @Override
    public CuotaResponse updateCuota(Long id, CuotaRequest cuotaRequest) {
        Cuota cuotaFound = cuotaRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Cuota no encontrada con id: " + id)
        );
        cuotaFound.setPrestamo(prestamoService.getPrestamoEntityById(cuotaRequest.getPrestamoId()));
        cuotaFound.setNumero(cuotaRequest.getNumero());
        cuotaFound.setMonto(cuotaRequest.getMonto());
        cuotaFound.setFechaVencimiento(cuotaRequest.getFechaVencimiento());
        cuotaFound.setMonto(cuotaRequest.getMonto());
        cuotaFound.setEstadoCuota(estadoCuotaService.getEstadoCuotaEntityById(cuotaRequest.getEstadoCuotaId()));

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
