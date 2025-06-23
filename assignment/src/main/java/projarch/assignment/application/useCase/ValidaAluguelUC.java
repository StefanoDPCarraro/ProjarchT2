package projarch.assignment.application.useCase;

import org.springframework.stereotype.Component;
import projarch.assignment.domain.services.AluguelService;


@Component
public class ValidaAluguelUC {
    private AluguelService aluguelService;
    
    public ValidaAluguelUC(AluguelService aluguelService){
        this.aluguelService = aluguelService;
        
    }
    
    public boolean execute(Integer id){
        return aluguelService.validaAluguel(id);
    }

}
