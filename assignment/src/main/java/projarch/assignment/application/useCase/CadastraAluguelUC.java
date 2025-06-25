package projarch.assignment.application.useCase;

import java.util.List;

import org.springframework.stereotype.Component;

import projarch.assignment.adapters.IMapper.IAlugueisMapper;
import projarch.assignment.application.dto.request.CreateAluguelDTO;
import projarch.assignment.application.dto.response.AluguelDTO;
import projarch.assignment.application.validator.AluguelValidator;
import projarch.assignment.domain.models.Cliente;
import projarch.assignment.domain.models.JogoModel;
import projarch.assignment.domain.services.AluguelService;
import projarch.assignment.domain.services.ClienteService;
import projarch.assignment.domain.services.JogosService;
import projarch.assignment.infra.mapperImpl.AluguelMapper;

@Component
public class CadastraAluguelUC {
    private AluguelService aluguelService;
    private IAlugueisMapper alugueisMapper;
    private ClienteService clienteService;
    private JogosService jogosService;

    public CadastraAluguelUC(AluguelService aluguelService, IAlugueisMapper alugueisMapper, ClienteService clienteService, JogosService jogosService){
        this.aluguelService = aluguelService;
        this.alugueisMapper = alugueisMapper;
        this.clienteService = clienteService;
        this.jogosService = jogosService;
    }

    public boolean execute(CreateAluguelDTO dto){
        List<AluguelDTO> alugueis = alugueisMapper.listModelToDTO(aluguelService.findByJogoId(dto.getJogo()));
        if (AluguelValidator.isValid(dto, alugueis) && !aluguelService.existsById(dto.getId())) {
            Cliente cliente =  clienteService.findById(dto.getCliente()).orElse(null);
            JogoModel jogo = jogosService.findById(dto.getJogo()).orElse(null);
            if(jogo == null || cliente == null) return false;

            return aluguelService.cadastraAluguel(alugueisMapper.toDomain(dto, cliente, jogo)) != null;
        }
        
        return false;
    }

}
