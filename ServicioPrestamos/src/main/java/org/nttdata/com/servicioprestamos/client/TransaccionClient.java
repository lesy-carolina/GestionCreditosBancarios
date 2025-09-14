package org.nttdata.com.servicioprestamos.client;

import org.nttdata.com.servicioprestamos.client.dto.TransaccionResponse;
import org.nttdata.com.servicioprestamos.configuration.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ServicioTransacciones", url = "http://localhost:8080/serviciotransacciones", configuration = FeignClientConfig.class)
public interface TransaccionClient {
    @GetMapping("/transacciones/cuenta/{cuentaId}")
    List<TransaccionResponse> obteTransacciones(@PathVariable Long cuentaId);
}
