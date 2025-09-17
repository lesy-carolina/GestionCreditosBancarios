package org.nttdata.com.servicionotificaciones.consumer.dto;


import lombok.Builder;

@Builder
public record ClienteResponseK(
    Long id,
    String nombre,
    String dni,
    String email,
    String estado
){

}
