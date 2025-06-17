package projarch.assignment.domain.services;

import java.util.List;

import org.springframework.stereotype.Service;

import projarch.assignment.adapters.repository.IJogoRepository;
import projarch.assignment.domain.models.JogoModel;

@Service
public class JogosService {
    private IJogoRepository jogoRepository;

    public JogosService(IJogoRepository jogoRepository){
        this.jogoRepository = jogoRepository;
    }

    public List<JogoModel> getAllJogos(){
        return jogoRepository.getAllJogos();
    }
}
