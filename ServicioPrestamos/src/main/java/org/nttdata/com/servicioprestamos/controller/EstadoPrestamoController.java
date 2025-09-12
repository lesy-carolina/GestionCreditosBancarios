package org.nttdata.com.servicioprestamos.controller;

import lombok.RequiredArgsConstructor;
import org.nttdata.com.servicioprestamos.dto.EstadoPrestamoRequest;
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
    public ResponseEntity<?> listarEstadoPrestamos() {
        return ResponseEntity.ok(estadoPrestamoService.getAllEstadosPrestamo());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerEstadoPrestamoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(estadoPrestamoService.getEstadoPrestamoById(id));
    }
    @PostMapping
    public ResponseEntity<?> crearEstadoPrestamo(@RequestBody EstadoPrestamoRequest estado) {
        return ResponseEntity.status(HttpStatus.CREATED).body(estadoPrestamoService.createEstadoPrestamo(estado));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarEstadoPrestamo(@PathVariable Long id, @RequestBody EstadoPrestamoRequest estado) {
        return ResponseEntity.ok(estadoPrestamoService.updateEstadoPrestamo(id, estado));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarEstadoPrestamo(@PathVariable Long id) {
        estadoPrestamoService.deleteEstadoPrestamo(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
