package org.nttdata.com.serviciotransacciones.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.nttdata.com.serviciotransacciones.dto.TransaccionRequest;
import org.nttdata.com.serviciotransacciones.dto.TransaccionResponse;
import org.nttdata.com.serviciotransacciones.model.Transaccion;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransaccionMapper {
    @Mapping(source = "tipoTransaccionId", target = "tipoTransaccion.id")
    Transaccion toEntity(TransaccionRequest transaccionRequest);
    TransaccionResponse toDto(Transaccion transaccion);
    List<TransaccionResponse> toDtoList(List<Transaccion> transacciones);
}
