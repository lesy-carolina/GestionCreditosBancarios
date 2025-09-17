package org.nttdata.com.serviciocuentas.repository;

import org.nttdata.com.serviciocuentas.model.EstadoCuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoCuentaRepository extends JpaRepository<EstadoCuenta, Long> {
}
