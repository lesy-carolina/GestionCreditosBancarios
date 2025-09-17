package org.nttdata.com.servicionotificaciones.util;

import org.mapstruct.Mapper;
import org.nttdata.com.servicionotificaciones.dto.TipoNotificacionRequest;
import org.nttdata.com.servicionotificaciones.dto.TipoNotificacionResponse;
import org.nttdata.com.servicionotificaciones.model.TipoNotificacion;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TipoNotificacionMapper {
    TipoNotificacion toEntity(TipoNotificacionRequest request);
    TipoNotificacionResponse toDto(TipoNotificacion entity);
    List<TipoNotificacionResponse> toDtoList(List<TipoNotificacion> entities);
}
