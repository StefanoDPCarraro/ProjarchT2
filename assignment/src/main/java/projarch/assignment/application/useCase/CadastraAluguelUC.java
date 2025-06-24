package projarch.assignment.application.useCase;

import org.springframework.stereotype.Component;

import projarch.assignment.adapters.IMapper.IAlugueisMapper;
import projarch.assignment.application.dto.request.CreateAluguelDTO;
import projarch.assignment.application.validator.AluguelValidator;
import projarch.assignment.domain.models.Cliente;
import projarch.assignment.domain.models.JogoModel;
import projarch.assignment.domain.services.AluguelService;
import projarch.assignment.domain.services.ClienteService;
import projarch.assignment.domain.services.JogosService;

@Component
public class CadastraAluguelUC {
    private AluguelService aluguelService;
    private IAlugueisMapper alugueisMapper;
    private ClienteService clienteService;
    private JogosService jogosService;

    public CadastraAluguelUC(AluguelService aluguelService, IAlugueisMapper alugueisMapper){
        this.aluguelService = aluguelService;
        this.alugueisMapper = alugueisMapper;
    }

    public boolean execute(CreateAluguelDTO dto){
        if (AluguelValidator.isValid(dto) && !aluguelService.existsById(dto.getId())) {
            Cliente cliente =  clienteService.findById(dto.getCliente()).orElse(null);
            JogoModel jogo = jogosService.findById(dto.getJogo()).orElse(null);
            if(jogo == null || cliente == null) return false;

            return aluguelService.cadastraAluguel(alugueisMapper.toDomain(dto, cliente, jogo)) != null;
        }
        
        return false;
    }

}
