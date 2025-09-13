package org.nttdata.com.serviciotransacciones.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TipoTransaccionResponse {
    private Long id;
    private String nombre;
}
