package projarch.assignment.infra.database.IJpaRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projarch.assignment.infra.database.entity.Jogo;

public interface IJogoJpaRepository extends JpaRepository<Jogo, Integer> {
    List<Jogo> findAll();
    Jogo save(Jogo jogo);
    void deleteAll();
}
