package projarch.assignment.application.useCase;

import org.springframework.stereotype.Component;

import projarch.assignment.adapters.IMapper.IJogosMapper;
import projarch.assignment.application.dto.response.JogoDTO;
import projarch.assignment.domain.services.JogosService;

@Component
public class CadastraJogoUC {
    private JogosService jogosService;
    private IJogosMapper jogosMapper;
    public CadastraJogoUC(JogosService jogosService, IJogosMapper jogosMapper) {
        this.jogosService = jogosService;
        this.jogosMapper = jogosMapper;
    }

    public boolean execute(JogoDTO jogoDTO) {
        return jogosService.salvaJogo(jogosMapper.dtoToModel(jogoDTO));
    }
}
