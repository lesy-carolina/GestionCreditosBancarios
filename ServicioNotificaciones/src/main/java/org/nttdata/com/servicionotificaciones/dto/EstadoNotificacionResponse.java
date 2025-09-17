package org.nttdata.com.servicionotificaciones.dto;

import lombok.Builder;

@Builder
public record EstadoNotificacionResponse(
    Long id,
    String estado
) {
}
