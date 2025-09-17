package org.nttdata.com.servicionotificaciones.repository;

import org.nttdata.com.servicionotificaciones.model.TipoNotificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoNotificacionRepository extends JpaRepository<TipoNotificacion, Long> {
}
