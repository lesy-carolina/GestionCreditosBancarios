package org.nttdata.com.serviciocuentas.controller;

import lombok.RequiredArgsConstructor;
import org.nttdata.com.serviciocuentas.dto.TipoCuentaRequest;
import org.nttdata.com.serviciocuentas.service.TipoCuentaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tipo-cuentas")
public class TipoCuentaController {
    private final TipoCuentaService tipoCuentaService;
    @GetMapping
    public ResponseEntity<?> getAllTipoCuentas() {
        return ResponseEntity.ok(tipoCuentaService.getAllTiposCuenta());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getTipoCuentaById(@PathVariable Long id) {
        return ResponseEntity.ok(tipoCuentaService.getTipoCuentaById(id));
    }
    @PostMapping
    public ResponseEntity<?> createTipoCuenta(@RequestBody TipoCuentaRequest tipoCuentaRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoCuentaService.createTipoCuenta(tipoCuentaRequest));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateTipoCuenta(@PathVariable Long id, @RequestBody TipoCuentaRequest tipoCuentaRequest) {
        return ResponseEntity.ok(tipoCuentaService.updateTipoCuenta(id, tipoCuentaRequest));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTipoCuenta(@PathVariable Long id) {
        tipoCuentaService.deleteTipoCuenta(id);
        return ResponseEntity.noContent().build();
    }
}
