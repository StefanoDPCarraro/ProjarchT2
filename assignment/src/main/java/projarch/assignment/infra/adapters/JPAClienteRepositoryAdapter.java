package projarch.assignment.infra.adapters;

import java.util.List;

import org.springframework.stereotype.Component;

import projarch.assignment.domain.models.cliente.Cliente;
import projarch.assignment.domain.repositories.IClienteRepository;
import projarch.assignment.infra.entities.cliente.ClienteEntity;
import projarch.assignment.infra.mapper.ClienteMapper;
import projarch.assignment.infra.repository.ClienteRepositoryJPA;

@Component
public class JPAClienteRepositoryAdapter implements IClienteRepository{
    private ClienteRepositoryJPA repository;
    private ClienteMapper clienteMapper;

    public JPAClienteRepositoryAdapter(ClienteRepositoryJPA repository, ClienteMapper clienteMapper) {
        this.repository = repository;
        this.clienteMapper = clienteMapper;
    }

    @Override
    public List<Cliente> findAll() {
        return clienteMapper.toDomain(repository.findAll());
    }

    @Override
    public Cliente save(Cliente cliente) {
        ClienteEntity entidade = clienteMapper.toEntity(cliente);
        entidade = repository.save(entidade);
        return clienteMapper.toDomain(entidade);
    }

    @Override
    public boolean existsById(Integer id){
        return repository.existsById(id);
    }

}
