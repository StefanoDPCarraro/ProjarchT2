package projarch.assignment.adapters.IMapper;

import java.util.List;

import projarch.assignment.application.dto.response.JogoDTO;
import projarch.assignment.domain.models.JogoModel;
import projarch.assignment.infra.database.entity.Jogo;

public interface IJogosMapper {
    JogoDTO modelToDTO(JogoModel jogoModel);
    List<JogoDTO> listModelToDTO(List<JogoModel> jogosModel);
    JogoModel entityToModel(Jogo jogo);
    List<JogoModel> listEntityToModel(List<Jogo> jogos);
    Jogo modelToEntity(JogoModel jogoModel);
    List<Jogo> listModelToEntity(List<JogoModel> jogosModel);
    JogoModel dtoToModel(JogoDTO jogoDTO);
    List<JogoModel> listDTOToModel(List<JogoDTO> jogosDTO);
}
