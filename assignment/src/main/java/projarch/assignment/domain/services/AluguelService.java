package projarch.assignment.domain.services;

import projarch.assignment.adapters.repository.IAluguelRepository;
import java.util.List;

import org.springframework.stereotype.Service;
import projarch.assignment.domain.models.AluguelModel;

@Service
public class AluguelService {
    private IAluguelRepository aluguelRepository;

    public AluguelService(IAluguelRepository aluguelRepository){
        this.aluguelRepository = aluguelRepository;
    }

    public List<AluguelModel> getAllAlugueis(){
        return aluguelRepository.getAllAlugueis();
    }
}
