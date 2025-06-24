package projarch.assignment.application.useCase;

import org.springframework.stereotype.Component;

import projarch.assignment.adapters.IMapper.IClienteMapper;
import projarch.assignment.application.dto.request.CreateClienteDTO;
import projarch.assignment.application.validator.ClienteValidator;
import projarch.assignment.domain.services.ClienteService;

@Component
public class CadastraClienteUC {
    private ClienteService clienteService;
    private IClienteMapper clienteMapper;

    public CadastraClienteUC(ClienteService clienteService, IClienteMapper clienteMapper) {
        this.clienteService = clienteService;
        this.clienteMapper = clienteMapper;
    }

    public boolean execute(CreateClienteDTO dto){
        if (ClienteValidator.isValid(dto) && !clienteService.existsById(dto.getNumero())) {
            return clienteService.cadastraCliente(clienteMapper.toDomain(dto)) != null;
        }
        
        return false;
    }
}
