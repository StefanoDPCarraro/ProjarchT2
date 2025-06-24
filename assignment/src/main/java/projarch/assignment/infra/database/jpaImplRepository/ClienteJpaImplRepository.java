package projarch.assignment.infra.database.jpaImplRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import projarch.assignment.adapters.repository.IClienteRepository;
import projarch.assignment.domain.models.Cliente;
import projarch.assignment.infra.database.IJpaRepository.IClienteJpaRepository;
import projarch.assignment.infra.database.entity.ClienteEntity;
import projarch.assignment.infra.mapperImpl.ClienteMapper;

@Component
public class ClienteJpaImplRepository implements IClienteRepository{
    private IClienteJpaRepository repository;
    private ClienteMapper clienteMapper;

    public ClienteJpaImplRepository(IClienteJpaRepository repository, ClienteMapper clienteMapper) {
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

    @Override
    public Optional<Cliente> findById(Integer id){
        return repository.findById(id)
        .map(clienteMapper::toDomain);
    }

}
