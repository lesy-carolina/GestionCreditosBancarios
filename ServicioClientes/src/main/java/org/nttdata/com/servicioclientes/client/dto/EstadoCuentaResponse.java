package org.nttdata.com.servicioclientes.client.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EstadoCuentaResponse {
    private Long id;
    private String nombre;
}
