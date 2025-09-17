package org.nttdata.com.servicioclientes.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRequest {
    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;
    @NotBlank(message = "El apellido no puede estar vacío")
    private String dni;
    @Email
    @NotBlank(message = "El email no puede estar vacío")
    private String email;
    @NotBlank(message = "El estado no puede estar vacío")
    private String estado;
}
