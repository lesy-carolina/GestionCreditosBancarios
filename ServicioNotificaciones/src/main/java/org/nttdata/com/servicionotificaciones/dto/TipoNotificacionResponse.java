package org.nttdata.com.servicionotificaciones.dto;

import lombok.Builder;

@Builder
public record TipoNotificacionResponse(
    Long id,
    String nombre
) {
}
