package org.nttdata.com.servicionotificaciones.service.impl;

import lombok.RequiredArgsConstructor;
import org.nttdata.com.servicionotificaciones.dto.NotificacionRequest;
import org.nttdata.com.servicionotificaciones.dto.NotificacionResponse;
import org.nttdata.com.servicionotificaciones.exception.ResourceNotFound;
import org.nttdata.com.servicionotificaciones.model.Notificacion;
import org.nttdata.com.servicionotificaciones.repository.NotificacionRepository;
import org.nttdata.com.servicionotificaciones.service.NotificacionService;
import org.nttdata.com.servicionotificaciones.util.NotificacionMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificacionServiceImpl implements NotificacionService {
    private final NotificacionRepository notificacionRepository;
    private final NotificacionMapper notificacionMapper;

    @Override
    public List<NotificacionResponse> getAllNotificaciones() {
        return notificacionMapper.toDtoList(notificacionRepository.findAll());
    }

    @Override
    public NotificacionResponse getNotificacionById(Long id) {
        return notificacionMapper.toDto(notificacionRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Notificacion not found with id " + id)
        ));
    }

    @Override
    public NotificacionResponse createNotificacion(NotificacionRequest request) {
        return notificacionMapper.toDto(notificacionRepository.save(notificacionMapper.toEntity(request)));
    }

    @Override
    public NotificacionResponse updateNotificacion(Long id, NotificacionRequest request) {
        Notificacion notificacionFound = notificacionRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Notificacion not found with id " + id)
        );

        notificacionFound.setClienteId(request.clienteId());
        notificacionFound.setTipoNotificacion(notificacionMapper.toEntity(request).getTipoNotificacion());
        notificacionFound.setEstadoNotificacion(notificacionMapper.toEntity(request).getEstadoNotificacion());
        notificacionFound.setAsunto(request.asunto());
        notificacionFound.setMensaje(request.mensaje());
        notificacionFound.setFechaEnvio(request.fechaEnvio());

        return notificacionMapper.toDto(notificacionRepository.save(notificacionFound));
    }

    @Override
    public void deleteNotificacion(Long id) {
        Notificacion notificacionFound = notificacionRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Notificacion not found with id " + id)
        );
        notificacionRepository.delete(notificacionFound);
    }
}
