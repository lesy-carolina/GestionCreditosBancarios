package org.nttdata.com.servicioprestamos.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EstadoCuotaRequest {
    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;
}
