package org.nttdata.com.servicionotificaciones.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.nttdata.com.servicionotificaciones.dto.TipoNotificacionRequest;
import org.nttdata.com.servicionotificaciones.service.TipoNotificacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tipo-notificaciones")
@RequiredArgsConstructor
public class TipoNotificacionController {
    private final TipoNotificacionService tipoNotificacionService;
    @GetMapping
    public ResponseEntity<?> getAllTipoNotificaciones() {
        return ResponseEntity.ok(tipoNotificacionService.getAllTiposNotificacion());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getTipoNotificacionById(@PathVariable Long id) {
        return ResponseEntity.ok(tipoNotificacionService.getTipoNotificacionById(id));
    }
    @PostMapping
    public ResponseEntity<?> createTipoNotificacion(@Valid @RequestBody TipoNotificacionRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoNotificacionService.saveTipoNotificacion(request));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateTipoNotificacion(@PathVariable Long id,@Valid @RequestBody TipoNotificacionRequest request) {
        return ResponseEntity.ok(tipoNotificacionService.updateTipoNotificacion(id, request));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTipoNotificacion(@PathVariable Long id) {
        tipoNotificacionService.deleteTipoNotificacion(id);
        return ResponseEntity.noContent().build();
    }
}
