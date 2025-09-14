package org.nttdata.com.servicioprestamos.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CuotaResponse {
    private PrestamoResponse prestamo;
    private Integer numero;
    private Date fechaVencimiento;
    private Double monto;
    private EstadoCuotaResponse estadoCuota;
}
