package org.nttdata.com.serviciotransacciones.dto;

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
public class TransaccionRequest {
    private Long cuentaId;
    private Long tipoTransaccionId;
    private BigDecimal monto;
    private Date fecha;
    private String referencia;
}
