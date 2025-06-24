package projarch.assignment.adapters.IMapper;

import java.util.List;

import projarch.assignment.application.dto.request.CreateClienteDTO;
import projarch.assignment.application.dto.response.ClienteResponseDTO;
import projarch.assignment.domain.models.Cliente;

public interface IClienteMapper {
    List<ClienteResponseDTO> toResponseDTO(List<Cliente> domain);
    Cliente toDomain(CreateClienteDTO dto);
}

