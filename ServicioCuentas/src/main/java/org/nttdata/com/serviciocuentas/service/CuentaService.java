package org.nttdata.com.serviciocuentas.service;

import org.nttdata.com.serviciocuentas.dto.CuentaRequest;
import org.nttdata.com.serviciocuentas.dto.CuentaResponse;
import java.math.BigDecimal;
import java.util.List;

public interface CuentaService {
    CuentaResponse crearCuenta(CuentaRequest request);
    CuentaResponse obtenerCuentaPorId(Long id);
    List<CuentaResponse> obtenerCuentasPorCliente(Long idCliente);
    List<CuentaResponse> obtenerTodasCuentas();
    CuentaResponse actualizarCuenta(Long id, CuentaRequest request);
    void eliminarCuenta(Long id);
    CuentaResponse actualizarSaldo(Long id, BigDecimal nuevoSaldo);
    CuentaResponse cambiarEstadoCuenta(Long id, String nuevoEstado);
}