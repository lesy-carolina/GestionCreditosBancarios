package org.nttdata.com.servicionotificaciones.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.nttdata.com.servicionotificaciones.dto.NotificacionRequest;
import org.nttdata.com.servicionotificaciones.service.NotificacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notificaciones")
@RequiredArgsConstructor
public class NotificacionController {
    private final NotificacionService notificacionService;
    @GetMapping
    public ResponseEntity<?> getAllNotificaciones() {
        return ResponseEntity.ok(notificacionService.getAllNotificaciones());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getNotificacionById(@PathVariable Long id) {
        return ResponseEntity.ok(notificacionService.getNotificacionById(id));
    }
    @PostMapping
    public ResponseEntity<?> createNotificacion(@Valid @RequestBody NotificacionRequest notificacion) {
        return ResponseEntity.status(HttpStatus.CREATED).body(notificacionService.createNotificacion(notificacion));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateNotificacion(@PathVariable Long id, @Valid @RequestBody NotificacionRequest notificacion) {
        return ResponseEntity.ok(notificacionService.updateNotificacion(id, notificacion));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNotificacion(@PathVariable Long id) {
        notificacionService.deleteNotificacion(id);
        return ResponseEntity.noContent().build();
    }
}
