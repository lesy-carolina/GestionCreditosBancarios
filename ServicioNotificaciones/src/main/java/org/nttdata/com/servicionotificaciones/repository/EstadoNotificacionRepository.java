package org.nttdata.com.servicionotificaciones.repository;

import org.nttdata.com.servicionotificaciones.model.EstadoNotificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoNotificacionRepository extends JpaRepository<EstadoNotificacion, Long> {
}
