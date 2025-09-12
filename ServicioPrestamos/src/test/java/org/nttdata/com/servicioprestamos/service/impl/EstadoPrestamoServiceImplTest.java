package org.nttdata.com.servicioprestamos.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.nttdata.com.servicioprestamos.dto.EstadoPrestamoResponse;
import org.nttdata.com.servicioprestamos.models.EstadoPrestamo;
import org.nttdata.com.servicioprestamos.repository.EstadoPrestamoRepository;
import org.nttdata.com.servicioprestamos.util.EstadoPrestamoMapper;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EstadoPrestamoServiceImplTest {
    @Mock
    private EstadoPrestamoRepository estadoPrestamoRepository;

    @Mock
    private EstadoPrestamoMapper estadoPrestamoMapper;

    @InjectMocks
    private EstadoPrestamoServiceImpl estadoPrestamoService;

    @Test
    void getAllEstadosPrestamo_ReturnsListOfEstadoPrestamoDto() {
        List<EstadoPrestamo> estados = List.of(EstadoPrestamo.builder().id(1L).nombre("Aprobado").build(), EstadoPrestamo.builder().id(2L).nombre("Rechazado").build());
        List<EstadoPrestamoResponse> estadosDto = List.of(new EstadoPrestamoResponse(1L, "Aprobado"), new EstadoPrestamoResponse(2L, "Rechazado"));

        when(estadoPrestamoRepository.findAll()).thenReturn(estados);
        when(estadoPrestamoMapper.toDtoList(estados)).thenReturn(estadosDto);

        List<EstadoPrestamoResponse> result = estadoPrestamoService.getAllEstadosPrestamo();

        assertEquals(estadosDto, result);
        verify(estadoPrestamoRepository).findAll();
        verify(estadoPrestamoMapper).toDtoList(estados);
    }
    @Test
    void getEstadoPrestamoById_ExistingId_ReturnsEstadoPrestamoDto() {
        Long id = 1L;
        EstadoPrestamo estado = EstadoPrestamo.builder().id(id).nombre("Aprobado").build();
        EstadoPrestamoResponse estadoDto = new EstadoPrestamoResponse(id, "Aprobado");


        when(estadoPrestamoRepository.findById(id)).thenReturn(Optional.of(estado));
        when(estadoPrestamoMapper.toDto(estado)).thenReturn(estadoDto);

        EstadoPrestamoResponse result = estadoPrestamoService.getEstadoPrestamoById(id);
        assertEquals(estadoDto, result);
        verify(estadoPrestamoRepository).findById(id);
        verify(estadoPrestamoMapper).toDto(estado);
    }
}
