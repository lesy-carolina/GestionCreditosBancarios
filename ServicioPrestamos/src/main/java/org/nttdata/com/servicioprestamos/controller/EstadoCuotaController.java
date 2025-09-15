package org.nttdata.com.servicioprestamos.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.nttdata.com.servicioprestamos.dto.EstadoCuotaRequest;
import org.nttdata.com.servicioprestamos.service.EstadoCuotaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/estado-cuotas")
public class EstadoCuotaController {
    private final EstadoCuotaService estadoCuotaService;

    @GetMapping
    public ResponseEntity<?> listarEstadosCuota() {
        return ResponseEntity.ok(estadoCuotaService.getAllEstadosCuota());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerEstadoCuotaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(estadoCuotaService.getEstadoCuotaById(id));
    }
    @PostMapping
    public ResponseEntity<?> crearEstadoCuota(@Valid @RequestBody EstadoCuotaRequest estadoCuotaRequest) {
        return ResponseEntity.ok(estadoCuotaService.saveEstadoCuota(estadoCuotaRequest));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarEstadoCuota(@PathVariable Long id, @Valid @RequestBody EstadoCuotaRequest estadoCuotaRequest) {
        return ResponseEntity.ok(estadoCuotaService.updateEstadoCuota(id, estadoCuotaRequest));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarEstadoCuota(@PathVariable Long id) {
        estadoCuotaService.deleteEstadoCuota(id);
        return ResponseEntity.noContent().build();
    }
}
