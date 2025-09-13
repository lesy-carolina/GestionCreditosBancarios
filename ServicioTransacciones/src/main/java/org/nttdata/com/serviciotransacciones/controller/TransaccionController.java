package org.nttdata.com.serviciotransacciones.controller;

import lombok.RequiredArgsConstructor;
import org.nttdata.com.serviciotransacciones.dto.TransaccionRequest;
import org.nttdata.com.serviciotransacciones.service.TransaccionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("transacciones")
@RequiredArgsConstructor
public class TransaccionController {
    private final TransaccionService transaccionService;

    @GetMapping
    public ResponseEntity<?> getAllTransacciones() {
        return ResponseEntity.ok(transaccionService.getAllTransacciones());
    }
    @GetMapping("/cuenta/{cuentaId}")
    public ResponseEntity<?> getTransaccionesByCuentaId(@PathVariable Long cuentaId) {
        return ResponseEntity.ok(transaccionService.getTransaccionesByCuentaId(cuentaId));
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getTransaccionById(@PathVariable Long id) {
        return ResponseEntity.ok(transaccionService.getTransaccionById(id));
    }
    @PostMapping
    public ResponseEntity<?> createTransaccion(@RequestBody TransaccionRequest transaccionRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(transaccionService.createTransaccion(transaccionRequest));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateTransaccion(@PathVariable Long id, @RequestBody TransaccionRequest transaccionRequest) {
        return ResponseEntity.ok(transaccionService.updateTransaccion(id, transaccionRequest));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTransaccion(@PathVariable Long id) {
        transaccionService.deleteTransaccion(id);
        return ResponseEntity.noContent().build();
    }
}
