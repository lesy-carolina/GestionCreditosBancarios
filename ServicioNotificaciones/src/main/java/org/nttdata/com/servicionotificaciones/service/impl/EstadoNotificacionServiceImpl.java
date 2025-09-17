package org.nttdata.com.servicionotificaciones.service.impl;

import lombok.RequiredArgsConstructor;
import org.nttdata.com.servicionotificaciones.dto.EstadoNotificacionRequest;
import org.nttdata.com.servicionotificaciones.dto.EstadoNotificacionResponse;
import org.nttdata.com.servicionotificaciones.exception.ResourceNotFound;
import org.nttdata.com.servicionotificaciones.model.EstadoNotificacion;
import org.nttdata.com.servicionotificaciones.repository.EstadoNotificacionRepository;
import org.nttdata.com.servicionotificaciones.service.EstadoNotificacionService;
import org.nttdata.com.servicionotificaciones.util.EstadoNotificacionMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstadoNotificacionServiceImpl implements EstadoNotificacionService {
    private final EstadoNotificacionRepository estadoNotificacionRepository;
    private final EstadoNotificacionMapper estadoNotificacionMapper;
    @Override
    public List<EstadoNotificacionResponse> getAllEstadosNotificacion() {
        return estadoNotificacionMapper.toDtoList(estadoNotificacionRepository.findAll());
    }

    @Override
    public EstadoNotificacionResponse getEstadoNotificacionById(Long id) {
        return estadoNotificacionMapper.toDto(estadoNotificacionRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("EstadoNotificacion not found with id " + id)
        ));
    }

    @Override
    public EstadoNotificacionResponse createEstadoNotificacion(EstadoNotificacionRequest request) {
        return estadoNotificacionMapper.toDto(estadoNotificacionRepository.save(estadoNotificacionMapper.toEntity(request)));
    }

    @Override
    public EstadoNotificacionResponse updateEstadoNotificacion(Long id, EstadoNotificacionRequest request) {
        EstadoNotificacion estadoNotificacionFound = estadoNotificacionRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("EstadoNotificacion not found with id " + id)
        );

        estadoNotificacionFound.setEstado(request.estado());

        return estadoNotificacionMapper.toDto(estadoNotificacionRepository.save(estadoNotificacionFound));
    }

    @Override
    public void deleteEstadoNotificacion(Long id) {
        EstadoNotificacion estadoNotificacionFound = estadoNotificacionRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("EstadoNotificacion not found with id " + id)
        );
        estadoNotificacionRepository.delete(estadoNotificacionFound);
    }
}
