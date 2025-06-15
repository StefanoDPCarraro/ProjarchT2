package projarch.assignment.application.interfaces;

import java.util.List;

import projarch.assignment.application.dto.cliente.ClienteResponseDTO;
import projarch.assignment.domain.models.cliente.Cliente;

public interface IClienteMapper {
    List<ClienteResponseDTO> toResponseDTO(List<Cliente> domain);
}
