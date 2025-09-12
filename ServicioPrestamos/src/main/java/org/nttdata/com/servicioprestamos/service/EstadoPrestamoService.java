package org.nttdata.com.servicioprestamos.service;

import org.nttdata.com.servicioprestamos.dto.EstadoPrestamoRequest;
import org.nttdata.com.servicioprestamos.dto.EstadoPrestamoResponse;

import java.util.List;

public interface EstadoPrestamoService {
    List<EstadoPrestamoResponse> getAllEstadosPrestamo();
    EstadoPrestamoResponse getEstadoPrestamoById(Long id);
    EstadoPrestamoResponse createEstadoPrestamo(EstadoPrestamoRequest estadoPrestamoDto);
    EstadoPrestamoResponse updateEstadoPrestamo(Long id, EstadoPrestamoRequest estadoPrestamoDto);
    void deleteEstadoPrestamo(Long id);
}
