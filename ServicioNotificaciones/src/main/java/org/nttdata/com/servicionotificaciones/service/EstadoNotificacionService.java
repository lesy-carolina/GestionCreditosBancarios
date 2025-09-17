package org.nttdata.com.servicionotificaciones.service;

import org.nttdata.com.servicionotificaciones.dto.EstadoNotificacionRequest;
import org.nttdata.com.servicionotificaciones.dto.EstadoNotificacionResponse;

import java.util.List;

public interface EstadoNotificacionService {
    List<EstadoNotificacionResponse> getAllEstadosNotificacion();
    EstadoNotificacionResponse getEstadoNotificacionById(Long id);
    EstadoNotificacionResponse createEstadoNotificacion(EstadoNotificacionRequest request);
    EstadoNotificacionResponse updateEstadoNotificacion(Long id, EstadoNotificacionRequest request);
    void deleteEstadoNotificacion(Long id);
}
