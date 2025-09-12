package org.nttdata.com.servicioprestamos.service;

import org.nttdata.com.servicioprestamos.dto.EstadoPrestamoDto;

import java.util.List;

public interface EstadoPrestamoService {
    List<EstadoPrestamoDto> getAllEstadosPrestamo();
    EstadoPrestamoDto getEstadoPrestamoById(Long id);
    EstadoPrestamoDto createEstadoPrestamo(EstadoPrestamoDto estadoPrestamoDto);
    EstadoPrestamoDto updateEstadoPrestamo(Long id, EstadoPrestamoDto estadoPrestamoDto);
    void deleteEstadoPrestamo(Long id);
}
