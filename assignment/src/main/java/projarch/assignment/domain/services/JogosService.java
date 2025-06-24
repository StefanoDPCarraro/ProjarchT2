package projarch.assignment.domain.services;

import java.util.List;
import java.util.Optional;

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

    public JogoModel salvaJogo(JogoModel jogo) {
        return jogoRepository.save(jogo);
    }

    public boolean validaJogo(int id){
        return jogoRepository.existsById(id);
    }

    public Optional<JogoModel> findById(int id){
        return jogoRepository.findById(id);
    }
}
