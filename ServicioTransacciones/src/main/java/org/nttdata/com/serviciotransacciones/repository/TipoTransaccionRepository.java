package org.nttdata.com.serviciotransacciones.repository;

import org.nttdata.com.serviciotransacciones.model.TipoTransaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoTransaccionRepository extends JpaRepository<TipoTransaccion, Long> {
}
