package org.nttdata.com.servicioclientes.client;

import org.nttdata.com.servicioclientes.client.dto.CuentaResponse;
import org.nttdata.com.servicioclientes.configuration.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ServicioCuentas", configuration = FeignClientConfig.class)
public interface CuentaClient {
    @GetMapping("cuentas/cliente/{idCliente}")
    List<CuentaResponse> getCuentasByClienteId(@PathVariable Long idCliente);
}
