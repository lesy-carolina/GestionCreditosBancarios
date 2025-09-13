package org.nttdata.com.serviciotransacciones.client.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CuentaResponse {
    private Long id;
    private Long clienteId;
    private Long tipoCuentaId;
    private Long estadoCuentaId;
    private BigDecimal saldo;

}
