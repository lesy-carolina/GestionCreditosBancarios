package org.nttdata.com.serviciocuentas.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "cuentas")
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long clienteId;

    @ManyToOne
    private TipoCuenta tipoCuenta;

    @ManyToOne
    private EstadoCuenta estadoCuenta;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal saldo;

}
