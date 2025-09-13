package org.nttdata.com.serviciotransacciones.util;

import org.mapstruct.Mapper;
import org.nttdata.com.serviciotransacciones.dto.TipoTransaccionRequest;
import org.nttdata.com.serviciotransacciones.dto.TipoTransaccionResponse;
import org.nttdata.com.serviciotransacciones.model.TipoTransaccion;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TipoTransaccionMapper {
    TipoTransaccion toEntity(TipoTransaccionRequest tipoTransaccionRequest);
    TipoTransaccionResponse toDto(TipoTransaccion tipoTransaccion);
    List<TipoTransaccionResponse> toDtoList(List<TipoTransaccion> tipoTransacciones);
}
