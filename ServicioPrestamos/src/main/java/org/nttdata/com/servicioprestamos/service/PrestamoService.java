package org.nttdata.com.servicioprestamos.service;

import org.nttdata.com.servicioprestamos.dto.PrestamoDto;

import java.util.List;

public interface PrestamoService {
    List<PrestamoDto> getAllPrestamos();
    PrestamoDto getPrestamoById(Long id);
    PrestamoDto createPrestamo(PrestamoDto prestamoDto);
    PrestamoDto updatePrestamo(Long id, PrestamoDto prestamoDto);
    void deletePrestamo(Long id);
}
