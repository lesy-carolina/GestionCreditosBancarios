package org.nttdata.com.servicioprestamos.client;

import org.nttdata.com.servicioprestamos.client.dto.CuentaResponse;
import org.nttdata.com.servicioprestamos.configuration.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ServicioCuentas", configuration = FeignClientConfig.class)
public interface CuentaClient {
    @GetMapping("/cuentas/{id}")
    CuentaResponse getCuentaById(@PathVariable Long id);
}
