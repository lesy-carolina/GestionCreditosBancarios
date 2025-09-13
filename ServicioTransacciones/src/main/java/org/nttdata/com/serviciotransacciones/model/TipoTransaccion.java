package org.nttdata.com.serviciotransacciones.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tipo_transacciones")
@Builder
@Entity
public class TipoTransaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre", nullable = false, length = 50, unique = true)
    private String nombre;

    @OneToMany(mappedBy = "tipoTransaccion")
    private List<Transaccion> transacciones;
}
