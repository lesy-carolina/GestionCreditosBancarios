package org.nttdata.com.servicioprestamos.service;

import org.nttdata.com.servicioprestamos.dto.PrestamoRequest;
import org.nttdata.com.servicioprestamos.dto.PrestamoResponse;

import java.util.List;

public interface PrestamoService {
    List<PrestamoResponse> getAllPrestamos();
    PrestamoResponse getPrestamoById(Long id);
    PrestamoResponse createPrestamo(PrestamoRequest prestamoDto);
    PrestamoResponse updatePrestamo(Long id, PrestamoRequest prestamoDto);
    void deletePrestamo(Long id);
}
