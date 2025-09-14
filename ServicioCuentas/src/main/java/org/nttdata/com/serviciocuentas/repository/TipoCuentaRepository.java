package org.nttdata.com.serviciocuentas.repository;

import org.nttdata.com.serviciocuentas.model.TipoCuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCuentaRepository extends JpaRepository<TipoCuenta, Long> {
}
