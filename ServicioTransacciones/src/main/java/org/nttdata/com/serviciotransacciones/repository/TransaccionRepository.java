package org.nttdata.com.serviciotransacciones.repository;

import org.nttdata.com.serviciotransacciones.model.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {
    List<Transaccion> findByCuentaId(Long cuentaId);
}
