package projarch.assignment.domain.services;

import java.util.List;

import org.springframework.stereotype.Service;

import projarch.assignment.adapters.repository.IAluguelRepository;
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

    public boolean validaAluguel(Integer id){
        return aluguelRepository.validaAluguel(id);
    }

    public List<AluguelModel> findByClienteId(Integer id){
        return aluguelRepository.findByClienteId(id);
    }

    public List<AluguelModel> findByJogoId(Integer id){
        return aluguelRepository.findByJogoId(id);
    }
}
