package projarch.assignment.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import projarch.assignment.adapters.repository.IClienteRepository;
import projarch.assignment.domain.models.Cliente;


@Service
public class ClienteService {
    private IClienteRepository clienteRepository;

    public ClienteService(IClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }

    public boolean existsById(Integer id){
        return clienteRepository.existsById(id);
    }

    public Cliente cadastraCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> findById(Integer id){
        return clienteRepository.findById(id);
    }


}
