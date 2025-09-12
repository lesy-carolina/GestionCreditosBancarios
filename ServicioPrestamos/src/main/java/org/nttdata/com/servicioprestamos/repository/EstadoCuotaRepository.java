package org.nttdata.com.servicioprestamos.repository;

import org.nttdata.com.servicioprestamos.models.EstadoCuota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoCuotaRepository extends JpaRepository<EstadoCuota, Long> {
}
