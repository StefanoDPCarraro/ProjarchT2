package projarch.assignment.adapters.IMapper;

import java.util.List;

import projarch.assignment.application.dto.request.CreateAluguelDTO;
import projarch.assignment.application.dto.response.AluguelDTO;
import projarch.assignment.domain.models.AluguelModel;
import projarch.assignment.domain.models.Cliente;
import projarch.assignment.domain.models.JogoModel;
import projarch.assignment.infra.database.entity.Aluguel;


public interface IAlugueisMapper {
    AluguelDTO modelToDTO(AluguelModel aluguelModel);
    List<AluguelDTO> listModelToDTO(List<AluguelModel> alugueisModel);
    AluguelModel entityToModel(Aluguel aluguel);
    List<AluguelModel> listEntityModel(List<Aluguel> alugueis);
    AluguelModel toDomain(CreateAluguelDTO dto, Cliente cliente, JogoModel jogo);
    AluguelModel toDomain(Aluguel aluguel);
    Aluguel toEntity(AluguelModel aluguel);
}
