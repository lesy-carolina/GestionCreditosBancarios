package org.nttdata.com.serviciotransacciones.service;

import org.nttdata.com.serviciotransacciones.dto.TransaccionRequest;
import org.nttdata.com.serviciotransacciones.dto.TransaccionResponse;

import java.util.List;

public interface TransaccionService {
    List<TransaccionResponse> getAllTransacciones();
    TransaccionResponse getTransaccionById(Long id);
    TransaccionResponse createTransaccion(TransaccionRequest transaccionRequest);
    TransaccionResponse updateTransaccion(Long id, TransaccionRequest transaccionRequest);
    void deleteTransaccion(Long id);

    List<TransaccionResponse> getTransaccionesByCuentaId(Long cuentaId);
}
