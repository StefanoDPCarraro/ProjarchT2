package projarch.assignment.application.useCase;

import java.util.List;

import org.springframework.stereotype.Component;

import projarch.assignment.adapters.IMapper.IJogosMapper;
import projarch.assignment.application.dto.response.JogoDTO;
import projarch.assignment.domain.services.JogosService;

@Component
public class GetAllJogosUC {
    private JogosService jogosService;
    private IJogosMapper jogosMapper;

    public GetAllJogosUC(JogosService jogosService, IJogosMapper jogosMapper) {
        this.jogosService = jogosService;
        this.jogosMapper = jogosMapper;
    }

    public List<JogoDTO> execute() {
        return jogosMapper.listModelToDTO(jogosService.getAllJogos());
    }
}