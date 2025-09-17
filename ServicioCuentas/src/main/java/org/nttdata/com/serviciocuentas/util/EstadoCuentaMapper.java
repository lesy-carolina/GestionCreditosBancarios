package org.nttdata.com.serviciocuentas.util;

import org.mapstruct.Mapper;
import org.nttdata.com.serviciocuentas.dto.EstadoCuentaRequest;
import org.nttdata.com.serviciocuentas.dto.EstadoCuentaResponse;
import org.nttdata.com.serviciocuentas.model.EstadoCuenta;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EstadoCuentaMapper {
    EstadoCuenta toEntity(EstadoCuentaRequest request);
    EstadoCuentaResponse toDto(EstadoCuenta entity);
    List<EstadoCuentaResponse> toDtoList(List<EstadoCuenta> entities);
}
