package org.nttdata.com.serviciocuentas.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.nttdata.com.serviciocuentas.dto.TipoCuentaRequest;
import org.nttdata.com.serviciocuentas.dto.TipoCuentaResponse;
import org.nttdata.com.serviciocuentas.model.TipoCuenta;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TipoCuentaMapper {
    TipoCuenta toEntity(TipoCuentaRequest request);
    TipoCuentaResponse toDto(TipoCuenta entity);
    List<TipoCuentaResponse> toDtoList(List<TipoCuenta> entities);
}
