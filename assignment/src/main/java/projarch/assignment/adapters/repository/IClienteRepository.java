package projarch.assignment.adapters.repository;

import java.util.List;
import java.util.Optional;

import projarch.assignment.domain.models.Cliente;


public interface IClienteRepository {
    List<Cliente> findAll();
    Cliente save(Cliente cliente);
    boolean existsById(Integer id);
    Optional<Cliente> findById(Integer id);
} 
