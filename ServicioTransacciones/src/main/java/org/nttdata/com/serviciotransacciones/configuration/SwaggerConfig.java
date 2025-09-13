package org.nttdata.com.serviciotransacciones.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Servicio de Transacciones")
                        .version("1.0.0")
                        .description("API para gestionar trasacciones en una aplicación bancaria.")
                );
    }
}
