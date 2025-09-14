package org.nttdata.com.servicioprestamos.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.nttdata.com.servicioprestamos.dto.EstadoPrestamoRequest;
import org.nttdata.com.servicioprestamos.dto.EstadoPrestamoResponse;
import org.nttdata.com.servicioprestamos.dto.PrestamoRequest;
import org.nttdata.com.servicioprestamos.dto.PrestamoResponse;
import org.nttdata.com.servicioprestamos.models.Prestamo;

import java.util.List;

@Mapper(componentModel = "spring", uses = EstadoPrestamoMapper.class)
public interface PrestamoMapper {
    @Mapping(target = "estadoPrestamo.id", source = "estadoPrestamoId")
    Prestamo toEntity(PrestamoRequest prestamoDto);
    PrestamoResponse toDto(Prestamo prestamo);
    List<PrestamoResponse> toDtoList(List<Prestamo> prestamos);
}
