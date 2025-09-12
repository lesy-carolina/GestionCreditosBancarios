package org.nttdata.com.servicioprestamos.util;

import org.mapstruct.Mapper;
import org.nttdata.com.servicioprestamos.dto.PrestamoDto;
import org.nttdata.com.servicioprestamos.models.Prestamo;

import java.util.List;

@Mapper(componentModel = "spring", uses = EstadoPrestamoMapper.class)
public interface PrestamoMapper {
    Prestamo toEntity(PrestamoDto prestamoDto);
    PrestamoDto toDto(Prestamo prestamo);
    List<PrestamoDto> toDtoList(List<Prestamo> prestamos);
}
