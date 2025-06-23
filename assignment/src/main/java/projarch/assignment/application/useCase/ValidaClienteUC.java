package projarch.assignment.application.useCase;

import org.springframework.stereotype.Component;

import projarch.assignment.domain.services.ClienteService;

@Component
public class ValidaClienteUC {
    private ClienteService clienteService;

    public ValidaClienteUC(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public Boolean execute(Integer id){
        return clienteService.existsById(id);
    }
    
}
