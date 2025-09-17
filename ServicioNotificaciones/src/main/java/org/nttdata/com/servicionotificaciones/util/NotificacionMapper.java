package org.nttdata.com.servicionotificaciones.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.nttdata.com.servicionotificaciones.dto.NotificacionRequest;
import org.nttdata.com.servicionotificaciones.dto.NotificacionResponse;
import org.nttdata.com.servicionotificaciones.model.Notificacion;

import java.util.List;

@Mapper(componentModel = "spring", uses = {EstadoNotificacionMapper.class, TipoNotificacionMapper.class})
public interface NotificacionMapper {
    @Mapping(source = "tipoNotificacionId", target = "tipoNotificacion.id")
    @Mapping(source = "estadoNotificacionId", target = "estadoNotificacion.id")
    Notificacion toEntity(NotificacionRequest notificacionRequest);
    NotificacionResponse toDto(Notificacion notificacion);
    List<NotificacionResponse> toDtoList(List<Notificacion> notificaciones);
}
