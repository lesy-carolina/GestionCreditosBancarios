package org.nttdata.com.servicionotificaciones.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "notificaciones")
public class Notificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long clienteId;
    @ManyToOne
    private TipoNotificacion tipoNotificacion;
    private String asunto;
    private String mensaje;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEnvio;
    @ManyToOne
    private EstadoNotificacion estadoNotificacion;
}
