package org.nttdata.com.servicioprestamos.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.nttdata.com.servicioprestamos.client.ClienteClient;
import org.nttdata.com.servicioprestamos.client.TransaccionClient;
import org.nttdata.com.servicioprestamos.client.dto.TipoTransaccionResponse;
import org.nttdata.com.servicioprestamos.client.dto.TransaccionResponse;
import org.nttdata.com.servicioprestamos.repository.PrestamoRepository;
import org.nttdata.com.servicioprestamos.service.PrestamoService;
import org.nttdata.com.servicioprestamos.util.PrestamoMapper;

import java.math.BigDecimal;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PrestamoServiceImplTest {
    @Mock
    private PrestamoMapper prestamoMapper;
    @Mock
    private PrestamoRepository prestamoRepository;
    @Mock
    private ClienteClient clienteClient;
    @Mock
    private TransaccionClient transaccionClient;

    @InjectMocks
    private PrestamoServiceImpl prestamoService;

    @Test
    void evalularCreditoTest(){
        Long cuentaId = 1L;
        BigDecimal montoSolicitado = new BigDecimal("5000");

        // Mock transacciones: 2 depósitos y 1 retiro
        List<TransaccionResponse> transacciones = List.of(
                TransaccionResponse.builder().tipoTransaccion(TipoTransaccionResponse.builder().nombre("DEPOSITO").build()).cuentaId(cuentaId).monto(new BigDecimal("50000")).build(),
                TransaccionResponse.builder().tipoTransaccion(TipoTransaccionResponse.builder().nombre("DEPOSITO").build()).cuentaId(cuentaId).monto(new BigDecimal("20000")).build(),
                TransaccionResponse.builder().tipoTransaccion(TipoTransaccionResponse.builder().nombre("RETIRO").build()).cuentaId(cuentaId).monto(new BigDecimal("10000")).build(),
                TransaccionResponse.builder().tipoTransaccion(TipoTransaccionResponse.builder().nombre("DEPOSITO").build()).cuentaId(cuentaId).monto(new BigDecimal("15000")).build()
        );
        Mockito.when(transaccionClient.obteTransacciones(cuentaId)).thenReturn(transacciones);

        // No debe lanzar excepción
        Assertions.assertDoesNotThrow(() -> prestamoService.evalularCredito(cuentaId, montoSolicitado));

    }
}
