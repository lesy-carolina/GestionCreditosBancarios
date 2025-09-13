package org.nttdata.com.serviciocuentas.service;

import org.nttdata.com.serviciocuentas.dto.EstadoCuentaRequest;
import org.nttdata.com.serviciocuentas.dto.EstadoCuentaResponse;
import org.nttdata.com.serviciocuentas.model.EstadoCuenta;

import java.util.List;

public interface EstadoCuentaService {
    List<EstadoCuentaResponse> getAllEstadosCuenta();
    EstadoCuentaResponse getEstadoCuentaById(Long id);
    EstadoCuenta getEstadoCuentaEntityById(Long id);
    EstadoCuentaResponse saveEstadoCuenta(EstadoCuentaRequest estadoCuentaRequest);
    EstadoCuentaResponse updateEstadoCuenta(Long id, EstadoCuentaRequest estadoCuentaRequest);
    void deleteEstadoCuenta(Long id);
}
