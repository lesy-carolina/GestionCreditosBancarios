package org.nttdata.com.servicioprestamos.util;

import org.mapstruct.Mapper;
import org.nttdata.com.servicioprestamos.dto.EstadoPrestamoDto;
import org.nttdata.com.servicioprestamos.models.EstadoPrestamo;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EstadoPrestamoMapper {
    EstadoPrestamo toEntity(EstadoPrestamoDto estadoPrestamoDto);
    EstadoPrestamoDto toDto(EstadoPrestamo estadoPrestamo);
    List<EstadoPrestamoDto> toDtoList(List<EstadoPrestamo> estadosPrestamo);
}
