package org.nttdata.com.servicionotificaciones.service;

import org.nttdata.com.servicionotificaciones.dto.TipoNotificacionRequest;
import org.nttdata.com.servicionotificaciones.dto.TipoNotificacionResponse;

import java.util.List;

public interface TipoNotificacionService {
    List<TipoNotificacionResponse> getAllTiposNotificacion();
    TipoNotificacionResponse getTipoNotificacionById(Long id);
    TipoNotificacionResponse saveTipoNotificacion(TipoNotificacionRequest request);
    TipoNotificacionResponse updateTipoNotificacion(Long id, TipoNotificacionRequest request);
    void deleteTipoNotificacion(Long id);
}
