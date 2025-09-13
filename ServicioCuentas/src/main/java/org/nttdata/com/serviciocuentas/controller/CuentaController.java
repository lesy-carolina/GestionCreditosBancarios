package org.nttdata.com.serviciocuentas.controller;

import org.nttdata.com.serviciocuentas.dto.CuentaRequest;
import org.nttdata.com.serviciocuentas.dto.CuentaResponse;
import org.nttdata.com.serviciocuentas.service.CuentaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/cuentas")
public class CuentaController {

    private static final Logger logger = LoggerFactory.getLogger(CuentaController.class);

    @Autowired
    private CuentaService cuentaService;

    @PostMapping
    public ResponseEntity<?> crearCuenta(@RequestBody CuentaRequest request) {
        logger.info("POST /api/cuentas - Crear nueva cuenta");

        try {
            CuentaResponse response = cuentaService.crearCuenta(request);
            logger.info("Cuenta creada exitosamente ID: {}", response.getId());
            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        } catch (Exception e) {
            logger.error("Error en POST /api/cuentas: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerCuenta(@PathVariable Long id) {
        logger.info("GET /api/cuentas/{} - Obtener cuenta", id);

        try {
            CuentaResponse response = cuentaService.obtenerCuentaPorId(id);
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            logger.error("Error en GET /api/cuentas/{}: {}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/cliente/{idCliente}")
    public ResponseEntity<?> obtenerCuentasPorCliente(@PathVariable Long idCliente) {
        logger.info("GET /api/cuentas/cliente/{} - Obtener cuentas por cliente", idCliente);

        try {
            List<CuentaResponse> responses = cuentaService.obtenerCuentasPorCliente(idCliente);
            return ResponseEntity.ok(responses);

        } catch (Exception e) {
            logger.error("Error en GET /api/cuentas/cliente/{}: {}", idCliente, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> obtenerTodasCuentas() {
        logger.info("GET /api/cuentas - Obtener todas las cuentas");

        try {
            List<CuentaResponse> responses = cuentaService.obtenerTodasCuentas();
            return ResponseEntity.ok(responses);

        } catch (Exception e) {
            logger.error("Error en GET /api/cuentas: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarCuenta(@PathVariable Long id, @RequestBody CuentaRequest request) {
        logger.info("PUT /api/cuentas/{} - Actualizar cuenta", id);

        try {
            CuentaResponse response = cuentaService.actualizarCuenta(id, request);
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            logger.error("Error en PUT /api/cuentas/{}: {}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarCuenta(@PathVariable Long id) {
        logger.info("DELETE /api/cuentas/{} - Eliminar cuenta", id);

        try {
            cuentaService.eliminarCuenta(id);
            return ResponseEntity.noContent().build();

        } catch (Exception e) {
            logger.error("Error en DELETE /api/cuentas/{}: {}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PatchMapping("/{id}/saldo")
    public ResponseEntity<?> actualizarSaldo(@PathVariable Long id, @RequestParam BigDecimal saldo) {
        logger.info("PATCH /api/cuentas/{}/saldo - Actualizar saldo: {}", id, saldo);

        try {
            CuentaResponse response = cuentaService.actualizarSaldo(id, saldo);
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            logger.error("Error en PATCH /api/cuentas/{}/saldo: {}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<?> cambiarEstadoCuenta(@PathVariable Long id, @RequestParam String estado) {
        logger.info("PATCH /api/cuentas/{}/estado - Cambiar estado: {}", id, estado);

        try {
            CuentaResponse response = cuentaService.cambiarEstadoCuenta(id, estado);
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            logger.error("Error en PATCH /api/cuentas/{}/estado: {}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        logger.info("GET /api/cuentas/health - Health check");
        return ResponseEntity.ok("Servicio de Cuentas está funcionando correctamente");
    }
}