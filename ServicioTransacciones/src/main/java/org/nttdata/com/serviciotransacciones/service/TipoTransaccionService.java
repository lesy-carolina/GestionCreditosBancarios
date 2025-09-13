package org.nttdata.com.serviciotransacciones.service;

import org.nttdata.com.serviciotransacciones.dto.TipoTransaccionRequest;
import org.nttdata.com.serviciotransacciones.dto.TipoTransaccionResponse;

import java.util.List;

public interface TipoTransaccionService {
    List<TipoTransaccionResponse> getAllTipoTransacciones();
    TipoTransaccionResponse getTipoTransaccionById(Long id);
    TipoTransaccionResponse createTipoTransaccion(TipoTransaccionRequest tipoTransaccionRequest);
    TipoTransaccionResponse updateTipoTransaccion(Long id, TipoTransaccionRequest tipoTransaccionRequest);
    void deleteTipoTransaccion(Long id);
}
