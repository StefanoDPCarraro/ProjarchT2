package projarch.assignment.application.useCase;

import java.util.List;

import org.springframework.stereotype.Component;

import projarch.assignment.application.dto.jogo.JogoDTO;
import projarch.assignment.domain.services.JogosService;
import projarch.assignment.infra.mapper.JogosMapper;

@Component
public class GetAllJogosUC {
    private JogosService jogosService;

    public GetAllJogosUC(JogosService jogosService) {
        this.jogosService = jogosService;
    }

    public List<JogoDTO> execute() {
        return JogosMapper.listModelToDTO(jogosService.getAllJogos());
    }
}