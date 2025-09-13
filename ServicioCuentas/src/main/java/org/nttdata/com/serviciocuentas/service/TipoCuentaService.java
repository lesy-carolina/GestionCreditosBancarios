package org.nttdata.com.serviciocuentas.service;

import org.nttdata.com.serviciocuentas.dto.TipoCuentaRequest;
import org.nttdata.com.serviciocuentas.dto.TipoCuentaResponse;

import java.util.List;

public interface TipoCuentaService {
    List<TipoCuentaResponse> getAllTiposCuenta();
    TipoCuentaResponse getTipoCuentaById(Long id);
    TipoCuentaResponse createTipoCuenta(TipoCuentaRequest tipoCuentaRequest);
    TipoCuentaResponse updateTipoCuenta(Long id, TipoCuentaRequest tipoCuentaRequest);
    void deleteTipoCuenta(Long id);
}
