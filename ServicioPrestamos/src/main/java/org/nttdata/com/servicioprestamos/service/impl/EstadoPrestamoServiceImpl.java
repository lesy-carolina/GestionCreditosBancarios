package org.nttdata.com.servicioprestamos.service.impl;

import lombok.RequiredArgsConstructor;
import org.nttdata.com.servicioprestamos.dto.EstadoPrestamoDto;
import org.nttdata.com.servicioprestamos.exception.ResourceNotFound;
import org.nttdata.com.servicioprestamos.models.EstadoPrestamo;
import org.nttdata.com.servicioprestamos.repository.EstadoPrestamoRepository;
import org.nttdata.com.servicioprestamos.service.EstadoPrestamoService;
import org.nttdata.com.servicioprestamos.util.EstadoPrestamoMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstadoPrestamoServiceImpl implements EstadoPrestamoService {
    private final EstadoPrestamoRepository estadoPrestamoRepository;
    private final EstadoPrestamoMapper estadoPrestamoMapper;


    @Override
    public List<EstadoPrestamoDto> getAllEstadosPrestamo() {
        return estadoPrestamoMapper.toDtoList(estadoPrestamoRepository.findAll());
    }

    @Override
    public EstadoPrestamoDto getEstadoPrestamoById(Long id) {
        return estadoPrestamoMapper.toDto(estadoPrestamoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Estado de préstamo no encontrado con id: " + id)
        ));
    }

    @Override
    public EstadoPrestamoDto createEstadoPrestamo(EstadoPrestamoDto estadoPrestamoDto) {
        estadoPrestamoDto.setId(null); // Asegurarse de que el ID sea nulo para crear un nuevo registro
        EstadoPrestamo estadoPrestamo = estadoPrestamoMapper.toEntity(estadoPrestamoDto);
        return estadoPrestamoMapper.toDto(estadoPrestamoRepository.save(estadoPrestamo));
    }

    @Override
    public EstadoPrestamoDto updateEstadoPrestamo(Long id, EstadoPrestamoDto estadoPrestamoDto) {
        EstadoPrestamo estadoPRestamoFound = estadoPrestamoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Estado de préstamo no encontrado con id: " + id)
        );

        estadoPRestamoFound.setNombre(estadoPrestamoDto.getNombre());

        return estadoPrestamoMapper.toDto(estadoPrestamoRepository.save(estadoPRestamoFound));
    }

    @Override
    public void deleteEstadoPrestamo(Long id) {
        EstadoPrestamo estadoPrestamoFound = estadoPrestamoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Estado de préstamo no encontrado con id: " + id)
        );
        estadoPrestamoRepository.delete(estadoPrestamoFound);
    }
}
