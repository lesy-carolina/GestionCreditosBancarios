package org.nttdata.com.servicionotificaciones.dto;

import lombok.Builder;

import java.util.Date;

@Builder
public record NotificacionResponse(
    Long id,
    Long clienteId,
    TipoNotificacionResponse tipoNotificacion,
    String asunto,
    String mensaje,
    Date fechaEnvio,
    EstadoNotificacionResponse estadoNotificacion
) {
}
