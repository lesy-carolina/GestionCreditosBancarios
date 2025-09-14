package org.nttdata.com.servicioprestamos.util;

import org.mapstruct.Mapper;
import org.nttdata.com.servicioprestamos.dto.EstadoPrestamoRequest;
import org.nttdata.com.servicioprestamos.dto.EstadoPrestamoResponse;
import org.nttdata.com.servicioprestamos.models.EstadoPrestamo;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EstadoPrestamoMapper {
    EstadoPrestamo toEntity(EstadoPrestamoRequest estadoPrestamoDto);
    EstadoPrestamoResponse toDto(EstadoPrestamo estadoPrestamo);
    List<EstadoPrestamoResponse> toDtoList(List<EstadoPrestamo> estadosPrestamo);
}
