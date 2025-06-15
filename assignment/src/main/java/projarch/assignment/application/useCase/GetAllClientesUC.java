package projarch.assignment.application.useCase;

import java.util.List;

import org.springframework.stereotype.Component;

import projarch.assignment.application.dto.cliente.ClienteResponseDTO;
import projarch.assignment.application.interfaces.IClienteMapper;
import projarch.assignment.domain.models.cliente.Cliente;
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
