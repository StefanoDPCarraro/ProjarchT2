package projarch.assignment.application.useCase;

import java.util.Optional;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Component;

import projarch.assignment.domain.models.JogoModel;
import projarch.assignment.domain.services.JogosService;

@Component
public class CalculaPrecoJogoUC {
    private JogosService jogosService;

    public CalculaPrecoJogoUC(JogosService jogosService) {
        this.jogosService = jogosService;
    }
    
    public double execute(Integer id){
        Optional<JogoModel> jogo = jogosService.findById(id);
        
        if(jogo.isEmpty()){
            throw new NoSuchElementException("Jogo com o id "+id+" não encontrado");
        }

        JogoModel jooj = jogo.get();
        return jooj.calcularValorAluguel();
    }
}
