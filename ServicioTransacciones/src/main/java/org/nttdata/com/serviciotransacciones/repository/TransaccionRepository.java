package org.nttdata.com.serviciotransacciones.repository;

import org.nttdata.com.serviciotransacciones.model.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {
}
