package org.nttdata.com.servicioclientes.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.nttdata.com.servicioclientes.client.CuentaClient;
import org.nttdata.com.servicioclientes.dto.ClienteRequest;
import org.nttdata.com.servicioclientes.dto.ClienteResponse;
import org.nttdata.com.servicioclientes.exception.ResourceNotFound;
import org.nttdata.com.servicioclientes.model.Cliente;
import org.nttdata.com.servicioclientes.repository.ClienteRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClienteServiceImplTest {

    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private CuentaClient cuentaClient;

    @InjectMocks
    private ClienteServiceImpl clienteService;

    @Test
    void crearCliente_createsClienteSuccessfully() {
        ClienteRequest request = new ClienteRequest("Juan Perez", "12345678", "juan.perez@example.com", "ACTIVO");
        Cliente cliente = new Cliente(1L, "Juan Perez", "12345678", "juan.perez@example.com", "ACTIVO");

        when(clienteRepository.findByDni(request.getDni())).thenReturn(Optional.empty());
        when(clienteRepository.findByEmail(request.getEmail())).thenReturn(Optional.empty());
        when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);

        ClienteResponse response = clienteService.crearCliente(request);

        assertEquals(cliente.getId(), response.getId());
        assertEquals(cliente.getNombre(), response.getNombre());
        verify(clienteRepository).save(any(Cliente.class));
    }


    @Test
    void obtenerClientePorId_returnsClienteSuccessfully() {
        Cliente cliente = new Cliente(1L, "Juan Perez", "12345678", "juan.perez@example.com", "ACTIVO");

        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));

        ClienteResponse response = clienteService.obtenerClientePorId(1L);

        assertEquals(cliente.getId(), response.getId());
        assertEquals(cliente.getNombre(), response.getNombre());
    }

    @Test
    void obtenerClientePorId_throwsExceptionWhenClienteNotFound() {
        when(clienteRepository.findById(1L)).thenReturn(Optional.empty());

        ResourceNotFound exception = assertThrows(ResourceNotFound.class, () -> clienteService.obtenerClientePorId(1L));
        assertEquals("Cliente no encontrado con ID: 1", exception.getMessage());
    }






    @Test
    void obtenerClienteConCuentas_throwsExceptionWhenClienteNotFound() {
        when(clienteRepository.existsById(1L)).thenReturn(false);

        ResourceNotFound exception = assertThrows(ResourceNotFound.class, () -> clienteService.obtenerClienteConCuentas(1L));
        assertEquals("Cliente no encontrado con ID: 1", exception.getMessage());
    }
}
