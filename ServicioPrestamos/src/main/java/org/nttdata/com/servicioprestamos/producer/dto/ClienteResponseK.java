package org.nttdata.com.servicioprestamos.producer.dto;


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
