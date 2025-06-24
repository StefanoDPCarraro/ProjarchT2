package projarch.assignment.application.useCase;

import org.springframework.stereotype.Component;

import projarch.assignment.domain.services.JogosService;

@Component
public class ValidaJogoUC {
    private JogosService jogosService;

    public ValidaJogoUC(JogosService jogosService) {
        this.jogosService = jogosService;
    }

    public boolean execute(int id){
        return jogosService.validaJogo(id);
    }
}
