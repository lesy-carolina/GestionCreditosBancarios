package org.nttdata.com.servicioprestamos.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.nttdata.com.servicioprestamos.dto.CuotaRequest;
import org.nttdata.com.servicioprestamos.dto.CuotaResponse;
import org.nttdata.com.servicioprestamos.models.Cuota;

import java.util.List;

@Mapper(componentModel = "spring", uses = {EstadoCuotaMapper.class, PrestamoMapper.class})
public interface CuotaMapper {
    @Mapping(source = "estadoCuotaId", target = "estadoCuota.id")
    @Mapping(source = "prestamoId", target = "prestamo.id")
    Cuota toEntity(CuotaRequest cuotaRequest);
    CuotaResponse toDto(Cuota cuota);
    List<CuotaResponse> toDtoList(List<Cuota> cuotas);

}
