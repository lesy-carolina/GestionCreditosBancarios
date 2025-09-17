package org.nttdata.com.servicionotificaciones.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record TipoNotificacionRequest(
        @NotBlank(message = "El nombre no puede estar vacío")
        String nombre
) {
}
