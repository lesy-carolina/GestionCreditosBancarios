package org.nttdata.com.servicioprestamos.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PrestamoResponse {
    private Long id;
    private Long clienteId;
    private Long cuentaId;
    private BigDecimal monto;
    private Integer plazoMeses;
    private BigDecimal tasaInteres;
    private EstadoPrestamoResponse estadoPrestamo;
    private Date fechaDesembolso;
}
