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
    List<Cuenta> findByIdCliente(Long idCliente);

    // Buscar cuentas por tipo
    List<Cuenta> findByTipoCuenta(TipoCuenta tipoCuenta);

    // Buscar cuentas por estado
    List<Cuenta> findByEstadoCuenta(EstadoCuenta estadoCuenta);

    // Buscar cuenta específica de un cliente
    @Query("SELECT c FROM Cuenta c WHERE c.idCliente = :idCliente AND c.id = :idCuenta")
    Optional<Cuenta> findByClienteAndCuentaId(@Param("idCliente") Long idCliente,
                                              @Param("idCuenta") Long idCuenta);

    // Verificar si cliente tiene cuenta de cierto tipo
    boolean existsByIdClienteAndTipoCuenta(Long idCliente, TipoCuenta tipoCuenta);
}