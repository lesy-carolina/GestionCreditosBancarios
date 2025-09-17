package org.nttdata.com.servicionotificaciones.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.Date;

@Builder
public record NotificacionRequest(
        @NotNull(message = "El ID del cliente no puede ser nulo")
        Long clienteId,
        @NotNull(message = "El ID del tipo de notificación no puede ser nulo")
        Long tipoNotificacionId,
        @NotBlank(message = "El asunto no puede estar vacío")
        String asunto,
        @NotBlank(message = "El mensaje no puede estar vacío")
        String mensaje,
        Date fechaEnvio,
        @NotNull(message = "El ID del estado de la notificación no puede ser nulo")
        Long estadoNotificacionId
) {
}
