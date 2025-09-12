package org.nttdata.com.servicioprestamos.util;

import org.mapstruct.Mapper;
import org.nttdata.com.servicioprestamos.dto.CuotaRequest;
import org.nttdata.com.servicioprestamos.dto.CuotaResponse;
import org.nttdata.com.servicioprestamos.models.Cuota;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CuotaMapper {
    Cuota toEntity(CuotaRequest cuotaRequest);
    CuotaResponse toDto(Cuota cuota);
    List<CuotaResponse> toDtoList(List<Cuota> cuotas);

}
