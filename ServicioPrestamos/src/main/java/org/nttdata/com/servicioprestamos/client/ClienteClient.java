package org.nttdata.com.servicioprestamos.client;

import org.nttdata.com.servicioprestamos.client.dto.ClienteResponse;
import org.nttdata.com.servicioprestamos.configuration.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "ServicioClientes", url = "http://localhost:8080/servicioclientes", configuration = FeignClientConfig.class)
public interface ClienteClient {
    @GetMapping("/clientes/{id}")
    ClienteResponse getClienteById(@PathVariable Long id);
}
