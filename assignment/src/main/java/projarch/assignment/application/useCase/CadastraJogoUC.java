package projarch.assignment.application.useCase;

import org.springframework.stereotype.Component;

import projarch.assignment.adapters.IMapper.IJogosMapper;
import projarch.assignment.application.dto.request.CreateJogoDTO;
import projarch.assignment.application.validator.JogoValidator;
import projarch.assignment.domain.services.JogosService;

@Component
public class CadastraJogoUC {
    private JogosService jogosService;
    private IJogosMapper jogosMapper;
    public CadastraJogoUC(JogosService jogosService, IJogosMapper jogosMapper) {
        this.jogosService = jogosService;
        this.jogosMapper = jogosMapper;
    }

    public boolean execute(CreateJogoDTO createJogoDTO) {
        if(JogoValidator.isValid(createJogoDTO) && !jogosService.validaJogo(createJogoDTO.getCodigo())) {
            return jogosService.salvaJogo(jogosMapper.createToModel(createJogoDTO)) != null;
        }
        return false;
    }
}
