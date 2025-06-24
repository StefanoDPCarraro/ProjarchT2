package projarch.assignment.infra.database.IJpaRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import projarch.assignment.infra.database.entity.Jogo;

public interface IJogoJpaRepository extends JpaRepository<Jogo, Integer> {
    List<Jogo> findAll();
    Jogo save(Jogo jogo);
    boolean existsById(int id);
    Optional<Jogo> findById(int id);
    void deleteAll();
}
