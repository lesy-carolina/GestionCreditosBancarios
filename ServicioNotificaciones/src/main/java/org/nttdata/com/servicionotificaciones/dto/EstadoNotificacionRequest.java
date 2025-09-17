package org.nttdata.com.servicionotificaciones.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
@Builder
public record EstadoNotificacionRequest(
        @NotBlank(message = "El estado no puede estar vacío")
        String estado
) {
}
