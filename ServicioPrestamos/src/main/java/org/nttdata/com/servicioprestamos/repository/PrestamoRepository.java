package org.nttdata.com.servicioprestamos.repository;

import org.nttdata.com.servicioprestamos.models.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
}
