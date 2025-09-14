package org.nttdata.com.servicioprestamos.service;

import org.nttdata.com.servicioprestamos.dto.EstadoCuotaRequest;
import org.nttdata.com.servicioprestamos.dto.EstadoCuotaResponse;
import org.nttdata.com.servicioprestamos.models.EstadoCuota;

import java.util.List;

public interface EstadoCuotaService {
    List<EstadoCuotaResponse> getAllEstadosCuota();
    EstadoCuotaResponse getEstadoCuotaById(Long id);
    EstadoCuota getEstadoCuotaEntityById(Long id);
    EstadoCuotaResponse saveEstadoCuota(EstadoCuotaRequest estadoCuotaRequest);
    EstadoCuotaResponse updateEstadoCuota(Long id, EstadoCuotaRequest estadoCuotaRequest);
    void deleteEstadoCuota(Long id);
}
