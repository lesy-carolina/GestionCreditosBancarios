package org.nttdata.com.servicioprestamos.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.nttdata.com.servicioprestamos.dto.PrestamoDto;
import org.nttdata.com.servicioprestamos.models.Prestamo;
import org.nttdata.com.servicioprestamos.service.PrestamoService;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class PrestamoControllerTest {
    private MockMvc mockMvc;

    @InjectMocks
    private PrestamoController prestamoController;

    @Mock
    private PrestamoService prestamoService;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(prestamoController).build();
    }

    @Test
    void obtenerPrestamoPorId() throws Exception {
        Long id = 1L;
        PrestamoDto prestamo = PrestamoDto.builder()
                .id(id)
                .clienteId(1L)
                .cuentaId(1L)
                .monto(new BigDecimal("1000.0"))
                .plazoMeses(12)
                .tasaInteres(new BigDecimal("5.0"))
                .fechaDesembolso((Date.valueOf(LocalDate.now())))
                .build();

        when(prestamoService.getPrestamoById(id)).thenReturn(prestamo);

        mockMvc.perform(
                MockMvcRequestBuilders.get("/prestamos/{id}", id)
                        .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
        .andExpect(jsonPath("$.clienteId").value(1L))
        .andExpect(jsonPath("$.cuentaId").value(1L))
        .andExpect(jsonPath("$.monto").value(1000.0))
        .andExpect(jsonPath("$.plazoMeses").value(12))
        .andExpect(jsonPath("$.tasaInteres").value(5.0))
        .andExpect(jsonPath("$.fechaDesembolso").exists());
    }
}
