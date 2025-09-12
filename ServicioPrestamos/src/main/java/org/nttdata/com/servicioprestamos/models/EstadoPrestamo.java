package org.nttdata.com.servicioprestamos.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "estado_prestamos")
@Builder
public class EstadoPrestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "estadoPrestamo")
    private List<Prestamo> prestamos;
}
