package org.nttdata.com.servicioprestamos.util;

import org.mapstruct.Mapper;
import org.nttdata.com.servicioprestamos.dto.EstadoCuotaRequest;
import org.nttdata.com.servicioprestamos.dto.EstadoCuotaResponse;
import org.nttdata.com.servicioprestamos.dto.EstadoPrestamoRequest;
import org.nttdata.com.servicioprestamos.dto.EstadoPrestamoResponse;
import org.nttdata.com.servicioprestamos.models.EstadoCuota;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EstadoCuotaMapper {
    EstadoCuota toEntity(EstadoCuotaRequest estadoPrestamoRequest);
    EstadoCuotaResponse toDto(EstadoCuota estadoCuota);
    List<EstadoCuotaResponse> toDtoList(List<EstadoCuota> estadoCuotas);
}
