package org.nttdata.com.servicionotificaciones.service.impl;

import lombok.RequiredArgsConstructor;
import org.nttdata.com.servicionotificaciones.dto.TipoNotificacionRequest;
import org.nttdata.com.servicionotificaciones.dto.TipoNotificacionResponse;
import org.nttdata.com.servicionotificaciones.exception.ResourceNotFound;
import org.nttdata.com.servicionotificaciones.model.TipoNotificacion;
import org.nttdata.com.servicionotificaciones.repository.TipoNotificacionRepository;
import org.nttdata.com.servicionotificaciones.service.TipoNotificacionService;
import org.nttdata.com.servicionotificaciones.util.TipoNotificacionMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TipoNotificacionServiceImpl implements TipoNotificacionService {
    private final TipoNotificacionRepository tipoNotificacionRepository;
    private final TipoNotificacionMapper tipoNotificacionMapper;
    @Override
    public List<TipoNotificacionResponse> getAllTiposNotificacion() {
        return tipoNotificacionMapper.toDtoList(tipoNotificacionRepository.findAll());
    }

    @Override
    public TipoNotificacionResponse getTipoNotificacionById(Long id) {
        return tipoNotificacionMapper.toDto(tipoNotificacionRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Tipo de notificación no encontrado con id: " + id)
        ));
    }

    @Override
    public TipoNotificacionResponse saveTipoNotificacion(TipoNotificacionRequest request) {
        return tipoNotificacionMapper.toDto(tipoNotificacionRepository.save(tipoNotificacionMapper.toEntity(request)));
    }

    @Override
    public TipoNotificacionResponse updateTipoNotificacion(Long id, TipoNotificacionRequest request) {
        TipoNotificacion tipoNotificacionFound = tipoNotificacionRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Tipo de notificación no encontrado con id: " + id)
        );
        tipoNotificacionFound.setNombre(request.nombre());
        return tipoNotificacionMapper.toDto(tipoNotificacionRepository.save(tipoNotificacionFound));
    }

    @Override
    public void deleteTipoNotificacion(Long id) {
        TipoNotificacion tipoNotificacionFound = tipoNotificacionRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Tipo de notificación no encontrado con id: " + id)
        );
        tipoNotificacionRepository.delete(tipoNotificacionFound);
    }
}
