package org.nttdata.com.serviciocuentas.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.nttdata.com.serviciocuentas.dto.CuentaRequest;
import org.nttdata.com.serviciocuentas.dto.CuentaResponse;
import org.nttdata.com.serviciocuentas.model.Cuenta;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CuentaMapper {
    @Mapping(source = "tipoCuentaId", target = "tipoCuenta.id")
    @Mapping(source = "estadoCuentaId", target = "estadoCuenta.id")
    Cuenta toEntity(CuentaRequest cuentaRequest);
    CuentaResponse toDto(Cuenta cuenta);
    List<CuentaResponse> toDtoList(List<Cuenta> cuentas);
}
