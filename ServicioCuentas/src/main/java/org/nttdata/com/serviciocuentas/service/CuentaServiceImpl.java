package org.nttdata.com.serviciocuentas.service;

import org.nttdata.com.serviciocuentas.dto.CuentaRequest;
import org.nttdata.com.serviciocuentas.dto.CuentaResponse;
import org.nttdata.com.serviciocuentas.model.Cuenta;
import org.nttdata.com.serviciocuentas.model.EstadoCuenta;
import org.nttdata.com.serviciocuentas.model.TipoCuenta;
import org.nttdata.com.serviciocuentas.repository.CuentaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CuentaServiceImpl implements CuentaService {

    private static final Logger logger = LoggerFactory.getLogger(CuentaServiceImpl.class);

    @Autowired
    private CuentaRepository cuentaRepository;

    private CuentaResponse mapToResponse(Cuenta cuenta) {
        if (cuenta == null) return null;

        CuentaResponse response = new CuentaResponse();
        response.setId(cuenta.getId());
        response.setIdCliente(cuenta.getIdCliente());
        response.setTipoCuenta(cuenta.getTipoCuenta().name());
        response.setEstadoCuenta(cuenta.getEstadoCuenta().name());
        response.setSaldo(cuenta.getSaldo());
        return response;
    }

    private Cuenta mapToEntity(CuentaRequest request) {
        if (request == null) return null;

        Cuenta cuenta = new Cuenta();
        cuenta.setIdCliente(request.getIdCliente());

        // Convertir String a Enum con validación
        try {
            cuenta.setTipoCuenta(TipoCuenta.valueOf(request.getTipoCuenta().toUpperCase()));
            cuenta.setEstadoCuenta(EstadoCuenta.valueOf(request.getEstadoCuenta().toUpperCase()));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Tipo o estado de cuenta inválido: " + e.getMessage());
        }

        cuenta.setSaldo(request.getSaldo() != null ? request.getSaldo() : BigDecimal.ZERO);
        return cuenta;
    }

    @Override
    @Transactional
    public CuentaResponse crearCuenta(CuentaRequest request) {
        logger.info("Creando cuenta para cliente ID: {}", request.getIdCliente());

        try {
            // Validaciones
            if (request.getIdCliente() == null) {
                throw new RuntimeException("ID de cliente es requerido");
            }

            if (request.getTipoCuenta() == null || request.getEstadoCuenta() == null) {
                throw new RuntimeException("Tipo y estado de cuenta son requeridos");
            }

            Cuenta cuenta = mapToEntity(request);
            Cuenta cuentaGuardada = cuentaRepository.save(cuenta);
            logger.info("Cuenta creada exitosamente ID: {}", cuentaGuardada.getId());

            return mapToResponse(cuentaGuardada);

        } catch (Exception e) {
            logger.error("Error al crear cuenta: {}", e.getMessage());
            throw new RuntimeException("Error al crear cuenta: " + e.getMessage());
        }
    }

    @Override
    @Transactional(readOnly = true)
    public CuentaResponse obtenerCuentaPorId(Long id) {
        logger.info("Buscando cuenta ID: {}", id);

        Optional<Cuenta> cuentaOpt = cuentaRepository.findById(id);
        if (cuentaOpt.isEmpty()) {
            logger.warn("Cuenta no encontrada ID: {}", id);
            throw new RuntimeException("Cuenta no encontrada con ID: " + id);
        }

        return mapToResponse(cuentaOpt.get());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CuentaResponse> obtenerCuentasPorCliente(Long idCliente) {
        logger.info("Buscando cuentas para cliente ID: {}", idCliente);

        List<Cuenta> cuentas = cuentaRepository.findByIdCliente(idCliente);
        logger.info("Encontradas {} cuentas para cliente ID: {}", cuentas.size(), idCliente);

        return cuentas.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CuentaResponse> obtenerTodasCuentas() {
        logger.info("Obteniendo todas las cuentas");

        List<Cuenta> cuentas = cuentaRepository.findAll();
        logger.info("Total de cuentas encontradas: {}", cuentas.size());

        return cuentas.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public CuentaResponse actualizarCuenta(Long id, CuentaRequest request) {
        logger.info("Actualizando cuenta ID: {}", id);

        try {
            Optional<Cuenta> cuentaOpt = cuentaRepository.findById(id);
            if (cuentaOpt.isEmpty()) {
                throw new RuntimeException("Cuenta no encontrada con ID: " + id);
            }

            Cuenta cuenta = cuentaOpt.get();

            // Actualizar solo campos proporcionados
            if (request.getTipoCuenta() != null) {
                cuenta.setTipoCuenta(TipoCuenta.valueOf(request.getTipoCuenta().toUpperCase()));
            }

            if (request.getEstadoCuenta() != null) {
                cuenta.setEstadoCuenta(EstadoCuenta.valueOf(request.getEstadoCuenta().toUpperCase()));
            }

            if (request.getSaldo() != null) {
                cuenta.setSaldo(request.getSaldo());
            }

            Cuenta cuentaActualizada = cuentaRepository.save(cuenta);
            logger.info("Cuenta actualizada exitosamente ID: {}", id);

            return mapToResponse(cuentaActualizada);

        } catch (Exception e) {
            logger.error("Error al actualizar cuenta ID {}: {}", id, e.getMessage());
            throw new RuntimeException("Error al actualizar cuenta: " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public void eliminarCuenta(Long id) {
        logger.info("Eliminando cuenta ID: {}", id);

        try {
            if (!cuentaRepository.existsById(id)) {
                throw new RuntimeException("Cuenta no encontrada con ID: " + id);
            }

            cuentaRepository.deleteById(id);
            logger.info("Cuenta eliminada exitosamente ID: {}", id);

        } catch (Exception e) {
            logger.error("Error al eliminar cuenta ID {}: {}", id, e.getMessage());
            throw new RuntimeException("Error al eliminar cuenta: " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public CuentaResponse actualizarSaldo(Long id, BigDecimal nuevoSaldo) {
        logger.info("Actualizando saldo cuenta ID: {} - Nuevo saldo: {}", id, nuevoSaldo);

        try {
            Optional<Cuenta> cuentaOpt = cuentaRepository.findById(id);
            if (cuentaOpt.isEmpty()) {
                throw new RuntimeException("Cuenta no encontrada con ID: " + id);
            }

            Cuenta cuenta = cuentaOpt.get();
            cuenta.setSaldo(nuevoSaldo);

            Cuenta cuentaActualizada = cuentaRepository.save(cuenta);
            logger.info("Saldo actualizado exitosamente para cuenta ID: {}", id);

            return mapToResponse(cuentaActualizada);

        } catch (Exception e) {
            logger.error("Error al actualizar saldo cuenta ID {}: {}", id, e.getMessage());
            throw new RuntimeException("Error al actualizar saldo: " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public CuentaResponse cambiarEstadoCuenta(Long id, String nuevoEstado) {
        logger.info("Cambiando estado cuenta ID: {} - Nuevo estado: {}", id, nuevoEstado);

        try {
            Optional<Cuenta> cuentaOpt = cuentaRepository.findById(id);
            if (cuentaOpt.isEmpty()) {
                throw new RuntimeException("Cuenta no encontrada con ID: " + id);
            }

            Cuenta cuenta = cuentaOpt.get();
            cuenta.setEstadoCuenta(EstadoCuenta.valueOf(nuevoEstado.toUpperCase()));

            Cuenta cuentaActualizada = cuentaRepository.save(cuenta);
            logger.info("Estado actualizado exitosamente para cuenta ID: {}", id);

            return mapToResponse(cuentaActualizada);

        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Estado de cuenta inválido: " + nuevoEstado);
        } catch (Exception e) {
            logger.error("Error al cambiar estado cuenta ID {}: {}", id, e.getMessage());
            throw new RuntimeException("Error al cambiar estado: " + e.getMessage());
        }
    }
}