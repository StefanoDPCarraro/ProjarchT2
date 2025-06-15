package projarch.assignment.domain.services;

import java.util.List;

import org.springframework.stereotype.Service;

import projarch.assignment.domain.models.JogoModel;
import projarch.assignment.domain.repository.IJogoRepository;

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
