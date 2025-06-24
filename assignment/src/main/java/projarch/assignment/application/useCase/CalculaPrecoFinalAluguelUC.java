package projarch.assignment.application.useCase;

import java.util.Optional;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Component;

import projarch.assignment.domain.services.AluguelService;
import projarch.assignment.domain.models.AluguelModel;



@Component
public class CalculaPrecoFinalAluguelUC {
    private AluguelService aluguelService;

    public CalculaPrecoFinalAluguelUC(AluguelService aluguelService){
        this.aluguelService = aluguelService;
    }

    public double execute(Integer id){
        Optional<AluguelModel> aluguel = aluguelService.findById(id);

        if(aluguel.isEmpty()){
            throw new NoSuchElementException("Aluguel de id "+id+" nao encontrado");
        }

        AluguelModel model = aluguel.get();
        return model.calculaValorFinalAluguel();
    }
}
