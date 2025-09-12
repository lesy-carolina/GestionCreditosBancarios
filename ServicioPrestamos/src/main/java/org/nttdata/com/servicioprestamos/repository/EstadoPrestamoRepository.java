package org.nttdata.com.servicioprestamos.repository;

import org.nttdata.com.servicioprestamos.models.EstadoPrestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoPrestamoRepository extends JpaRepository<EstadoPrestamo, Long> {
}
