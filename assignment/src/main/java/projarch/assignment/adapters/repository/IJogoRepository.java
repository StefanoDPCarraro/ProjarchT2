package projarch.assignment.adapters.repository;

import java.util.List;

import projarch.assignment.domain.models.JogoModel;

public interface IJogoRepository {
    List<JogoModel> getAllJogos();
    boolean salvaJogo(JogoModel jogo);
    boolean existsById(int id);
}
