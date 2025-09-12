package org.nttdata.com.servicioprestamos.controller;

import lombok.RequiredArgsConstructor;
import org.nttdata.com.servicioprestamos.dto.EstadoPrestamoDto;
import org.nttdata.com.servicioprestamos.service.EstadoPrestamoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estado-prestamos")
@RequiredArgsConstructor
public class EstadoPrestamoController {
    private final EstadoPrestamoService estadoPrestamoService;

    @GetMapping
    private ResponseEntity<?> listarEstadoPrestamos() {
        return ResponseEntity.ok(estadoPrestamoService.getAllEstadosPrestamo());
    }
    @GetMapping("/{id}")
    private ResponseEntity<?> obtenerEstadoPrestamoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(estadoPrestamoService.getEstadoPrestamoById(id));
    }
    @PostMapping
    private ResponseEntity<?> crearEstadoPrestamo(@RequestBody EstadoPrestamoDto estado) {
        return ResponseEntity.status(HttpStatus.CREATED).body(estadoPrestamoService.createEstadoPrestamo(estado));
    }
    @PutMapping("/{id}")
    private ResponseEntity<?> actualizarEstadoPrestamo(@PathVariable Long id, @RequestBody EstadoPrestamoDto estado) {
        return ResponseEntity.ok(estadoPrestamoService.updateEstadoPrestamo(id, estado));
    }
    @DeleteMapping("/{id}")
    private ResponseEntity<?> eliminarEstadoPrestamo(@PathVariable Long id) {
        estadoPrestamoService.deleteEstadoPrestamo(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
