package org.nttdata.com.servicionotificaciones.util;

import org.mapstruct.Mapper;
import org.nttdata.com.servicionotificaciones.dto.EstadoNotificacionRequest;
import org.nttdata.com.servicionotificaciones.dto.EstadoNotificacionResponse;
import org.nttdata.com.servicionotificaciones.model.EstadoNotificacion;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EstadoNotificacionMapper {
    EstadoNotificacion toEntity(EstadoNotificacionRequest request);
    EstadoNotificacionResponse toDto(EstadoNotificacion entity);
    List<EstadoNotificacionResponse> toDtoList(List<EstadoNotificacion> entities);
}
