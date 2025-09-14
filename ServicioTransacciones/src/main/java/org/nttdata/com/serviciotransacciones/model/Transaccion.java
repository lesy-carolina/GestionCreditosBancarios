package org.nttdata.com.serviciotransacciones.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "transacciones")
@Entity
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cuentaId;
    @ManyToOne
    private TipoTransaccion tipoTransaccion;
    private BigDecimal monto;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    private String referencia;
}
