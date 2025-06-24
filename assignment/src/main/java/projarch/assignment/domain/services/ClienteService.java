package projarch.assignment.domain.services;

import java.util.List;

import org.springframework.stereotype.Service;

import projarch.assignment.adapters.repository.IClienteRepository;
import projarch.assignment.domain.models.Cliente;
import projarch.assignment.domain.models.Empresarial;
import projarch.assignment.domain.models.Individual;



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

    public Cliente cadastraIndividual(String nome, String endereco, String cpf){
        Cliente individual = new Individual(null, nome, endereco, cpf);
        return clienteRepository.save(individual);
    }

    public Cliente cadastraEmpresarial(String nome, String endereco, String nomeFantasia, String cnpj){
        Cliente empresarial = new Empresarial(null, nome, endereco, nomeFantasia, cnpj);
        return clienteRepository.save(empresarial);
    }

}
