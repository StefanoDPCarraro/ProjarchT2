package projarch.assignment.domain.repositories;

import java.util.List;

import projarch.assignment.domain.models.cliente.Cliente;

public interface IClienteRepository {
    List<Cliente> findAll();
    Cliente save(Cliente cliente);
} 
