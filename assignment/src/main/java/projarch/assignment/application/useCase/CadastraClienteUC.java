package projarch.assignment.application.useCase;

import org.springframework.stereotype.Component;

import projarch.assignment.application.dto.cliente.CreateClienteDTO;
import projarch.assignment.application.validator.ClienteValidator;
import projarch.assignment.domain.services.ClienteService;

@Component
public class CadastraClienteUC {
    private ClienteService clienteService;

    public CadastraClienteUC(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public boolean execute(CreateClienteDTO dto){
        if (ClienteValidator.isValid(dto)) {
            if (dto.getTipo().equalsIgnoreCase("individual")) {
                clienteService.cadastraIndividual(dto.getNome(), dto.getEndereço(), dto.getCpf());
            } else if (dto.getTipo().equalsIgnoreCase("empresarial")) {
                clienteService.cadastraEmpresarial(dto.getNome(), dto.getEndereço(), dto.getNomeFantasia(), dto.getCnpj());
            }
            else{
                return false; // Tipo inválido
            }
        }
        
        return true;
    }
}
