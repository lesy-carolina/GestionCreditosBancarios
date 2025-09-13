package org.nttdata.com.serviciotransacciones.client;

import org.nttdata.com.serviciotransacciones.client.dto.CuentaResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ServicioCuentas", url = "http://localhost:8080/serviciocuentas")
public interface CuentaClient {
    @GetMapping("/cuentas/{id}")
    CuentaResponse getCuentaById(@PathVariable Long id);
}
