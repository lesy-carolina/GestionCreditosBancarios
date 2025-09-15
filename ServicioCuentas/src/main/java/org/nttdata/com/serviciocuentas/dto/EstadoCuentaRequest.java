package org.nttdata.com.serviciocuentas.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EstadoCuentaRequest {
    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;
}
