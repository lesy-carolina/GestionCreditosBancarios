package org.nttdata.com.serviciocuentas.repository;

import org.nttdata.com.serviciocuentas.model.Cuenta;
import org.nttdata.com.serviciocuentas.model.EstadoCuenta;
import org.nttdata.com.serviciocuentas.model.TipoCuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long> {

    // Buscar cuentas por cliente
    List<Cuenta> findByClienteId(Long idCliente);

    // Buscar cuentas por tipo
    List<Cuenta> findByTipoCuenta(TipoCuenta tipoCuenta);

    // Buscar cuentas por estado
    List<Cuenta> findByEstadoCuenta(EstadoCuenta estadoCuenta);

    Optional<Cuenta> findByClienteIdAndId(Long clienteId, Long id);

    // Verificar si cliente tiene cuenta de cierto tipo
    boolean existsByClienteIdAndTipoCuenta(Long idCliente, TipoCuenta tipoCuenta);
}