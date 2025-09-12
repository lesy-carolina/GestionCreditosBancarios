package org.nttdata.com.servicioprestamos.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "cuotas")
public class Cuota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Prestamo prestamo;
    private Integer numero;
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
    private Double monto;
    @ManyToOne
    private EstadoCuota estadoCuota;
}
