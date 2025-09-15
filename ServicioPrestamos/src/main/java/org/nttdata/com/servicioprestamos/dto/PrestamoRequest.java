package org.nttdata.com.servicioprestamos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
public class PrestamoRequest {
    @NotNull(message = "El ID del cliente no puede ser nulo")
    private Long clienteId;
    @NotNull(message = "El ID de la cuenta no puede ser nulo")
    private Long cuentaId;
    @NotBlank(message = "El monto no puede estar vacío")
    @Positive(message = "El monto debe ser un valor positivo")
    private BigDecimal monto;
    @NotNull(message = "El plazo en meses no puede ser nulo")
    @Positive(message = "El plazo en meses debe ser un valor positivo")
    private Integer plazoMeses;
    @NotNull(message = "La tasa de interés no puede ser nula")
    @Positive(message = "La tasa de interés debe ser un valor positivo")
    private BigDecimal tasaInteres;
    private Long estadoPrestamoId;
    private Date fechaDesembolso;
}
