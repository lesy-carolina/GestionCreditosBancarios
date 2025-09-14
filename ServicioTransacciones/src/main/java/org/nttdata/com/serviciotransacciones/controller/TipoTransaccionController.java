package org.nttdata.com.serviciotransacciones.controller;

import lombok.RequiredArgsConstructor;
import org.nttdata.com.serviciotransacciones.dto.TipoTransaccionRequest;
import org.nttdata.com.serviciotransacciones.service.TipoTransaccionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tipo-transacciones")
@RequiredArgsConstructor
public class TipoTransaccionController {
    private final TipoTransaccionService tipoTransaccionService;

    @GetMapping
    public ResponseEntity<?> getAllTipoTransacciones() {
        return ResponseEntity.ok(tipoTransaccionService.getAllTipoTransacciones());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getTipoTransaccionById(@PathVariable Long id) {
        return ResponseEntity.ok(tipoTransaccionService.getTipoTransaccionById(id));
    }
    @PostMapping
    public ResponseEntity<?> createTipoTransaccion(@RequestBody TipoTransaccionRequest tipoTransaccionRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoTransaccionService.createTipoTransaccion(tipoTransaccionRequest));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateTipoTransaccion(@PathVariable Long id, @RequestBody TipoTransaccionRequest tipoTransaccionRequest) {
        return ResponseEntity.ok(tipoTransaccionService.updateTipoTransaccion(id, tipoTransaccionRequest));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTipoTransaccion(@PathVariable Long id) {
        tipoTransaccionService.deleteTipoTransaccion(id);
        return ResponseEntity.noContent().build();
    }
}
