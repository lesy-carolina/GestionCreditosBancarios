package org.nttdata.com.servicionotificaciones.service;

import org.nttdata.com.servicionotificaciones.dto.NotificacionRequest;
import org.nttdata.com.servicionotificaciones.dto.NotificacionResponse;

import java.util.List;

public interface NotificacionService {
    List<NotificacionResponse> getAllNotificaciones();
    NotificacionResponse getNotificacionById(Long id);
    NotificacionResponse createNotificacion(NotificacionRequest request);
    NotificacionResponse updateNotificacion(Long id, NotificacionRequest request);
    void deleteNotificacion(Long id);
}
