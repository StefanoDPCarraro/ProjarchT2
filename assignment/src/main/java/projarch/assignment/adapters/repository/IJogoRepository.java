package projarch.assignment.adapters.repository;

import java.util.List;
import java.util.Optional;

import projarch.assignment.domain.models.JogoModel;

public interface IJogoRepository {
    List<JogoModel> getAllJogos();
    JogoModel save(JogoModel jogo);
    boolean existsById(int id);
    Optional<JogoModel> findById(int id);
}
