package projarch.assignment.adapters.IMapper;

import projarch.assignment.application.dto.response.AluguelDTO;
import projarch.assignment.domain.models.AluguelModel;
import projarch.assignment.infra.database.entity.Aluguel;

import java.util.List;

import org.springframework.stereotype.Component;


public interface IAlugueisMapper {
    AluguelDTO modelToDTO(AluguelModel aluguelModel);
    List<AluguelDTO> listModelToDTO(List<AluguelModel> alugueisModel);
    AluguelModel entityToModel(Aluguel aluguel);
    List<AluguelModel> listEntityModel(List<Aluguel> algueis);
}
