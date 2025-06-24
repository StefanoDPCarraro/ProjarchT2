package projarch.assignment.application.useCase;

import java.util.List;

import org.springframework.stereotype.Component;

import projarch.assignment.adapters.IMapper.IClienteMapper;
import projarch.assignment.application.dto.response.ClienteResponseDTO;
import projarch.assignment.domain.models.Cliente;
import projarch.assignment.domain.services.ClienteService;

@Component
public class GetAllClientesUC {
    private ClienteService clienteService;
    private IClienteMapper clienteMapper;

    public GetAllClientesUC(ClienteService clienteService, IClienteMapper clienteMapper) {
        this.clienteService = clienteService;
        this.clienteMapper = clienteMapper;
    }

    public List<ClienteResponseDTO> execute(){
        List<Cliente> clientes = clienteService.findAll();
        return clienteMapper.toResponseDTO(clientes);
    }
    
}
