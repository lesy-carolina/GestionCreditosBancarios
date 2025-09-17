package org.nttdata.com.servicionotificaciones.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.nttdata.com.servicionotificaciones.dto.EstadoNotificacionRequest;
import org.nttdata.com.servicionotificaciones.service.EstadoNotificacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/estado-notificaciones")
public class EstadoNotificacionController {
    private final EstadoNotificacionService estadoNotificacionService;
    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(estadoNotificacionService.getAllEstadosNotificacion());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(estadoNotificacionService.getEstadoNotificacionById(id));
    }
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody EstadoNotificacionRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(estadoNotificacionService.createEstadoNotificacion(request));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@Valid @RequestBody EstadoNotificacionRequest request) {
        return ResponseEntity.ok(estadoNotificacionService.updateEstadoNotificacion(id, request));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        estadoNotificacionService.deleteEstadoNotificacion(id);
        return ResponseEntity.noContent().build();
    }
}
