package projarch.assignment.domain.services;

import java.util.List;

import org.springframework.stereotype.Service;

import projarch.assignment.domain.models.cliente.Cliente;
import projarch.assignment.domain.models.cliente.Empresarial;
import projarch.assignment.domain.models.cliente.Individual;
import projarch.assignment.domain.repositories.IClienteRepository;

@Service
public class ClienteService {
    private IClienteRepository clienteRepository;

    public ClienteService(IClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;

        //Inserções de teste
        Cliente c1 = new Empresarial(null, "Empresa Alpha", "Rua A, 100", "Emp Alpha", "12345678000123");
        Cliente c2 = new Empresarial(null, "Empresa Beta", "Rua B, 200", "Emp Beta", "23456789000134");
        Cliente c3 = new Empresarial(null, "Empresa Gamma", "Rua C, 300", "Emp Gamma", "34567890100145");
        Cliente c4 = new Individual(null, "João Silva", "Rua D, 400", "12345678901");
        Cliente c5 = new Individual(null, "Maria Oliveira", "Rua E, 500", "98765432100");

        clienteRepository.save(c1);
        clienteRepository.save(c2);
        clienteRepository.save(c3);
        clienteRepository.save(c4);
        clienteRepository.save(c5);
    }

    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }

    public boolean existsById(Integer id){
        return clienteRepository.existsById(id);
    }


}
