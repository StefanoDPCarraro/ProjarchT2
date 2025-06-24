package projarch.assignment.application.useCase;

import java.util.List;

import org.springframework.stereotype.Component;

import projarch.assignment.adapters.IMapper.IAlugueisMapper;
import projarch.assignment.application.dto.response.AluguelDTO;
import projarch.assignment.domain.services.AluguelService;

@Component
public class ListaAlugueisByClienteUC {
    private AluguelService aluguelService;
    private IAlugueisMapper alugueisMapper;

    public ListaAlugueisByClienteUC(AluguelService aluguelService, IAlugueisMapper alugueisMapper) {
        this.aluguelService = aluguelService;
        this.alugueisMapper = alugueisMapper;
    }

    public List<AluguelDTO> execute(int id){
        return alugueisMapper.listModelToDTO(aluguelService.findByClienteId(id));
    }
}
