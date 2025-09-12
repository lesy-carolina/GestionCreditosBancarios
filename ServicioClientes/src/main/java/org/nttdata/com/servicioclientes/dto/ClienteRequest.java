package org.nttdata.com.servicioclientes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRequest {
    private String nombre;
    private String dni;
    private String email;
    private String estado;
}
