package projarch.assignment.application.useCase;

import projarch.assignment.application.dto.cliente.CreateClienteDTO;
import projarch.assignment.domain.services.ClienteService;

public class CadastraClienteUC {
    private ClienteService clienteService;

    public CadastraClienteUC(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public boolean execute(CreateClienteDTO dto){
        if (dto.getTipo().trim().equalsIgnoreCase("empresarial")) {
            
        }
        else if(dto.getTipo().trim().equalsIgnoreCase("individual"){

        }
        else{
        }
        
        return true;
    }
}
