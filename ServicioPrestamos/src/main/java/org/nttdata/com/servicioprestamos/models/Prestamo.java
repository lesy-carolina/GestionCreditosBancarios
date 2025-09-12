package org.nttdata.com.servicioprestamos.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "prestamos")
@Builder
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY
    )
    private Long id;
    private Long clienteId;
    private Long cuentaId;
    private BigDecimal monto;
    private Integer plazoMeses;
    private BigDecimal tasaInteres;
    @ManyToOne
    private EstadoPrestamo estadoPrestamo;
    @Temporal(TemporalType.DATE)
    @ColumnDefault(value = "CURRENT_DATE")
    private Date fechaDesembolso;

    @OneToMany(mappedBy = "prestamo")
    private List<Cuota> cuotas;
}
