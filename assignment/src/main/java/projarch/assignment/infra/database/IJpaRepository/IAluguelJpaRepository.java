package projarch.assignment.infra.database.IJpaRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projarch.assignment.infra.database.entity.Aluguel;

public interface IAluguelJpaRepository extends JpaRepository<Aluguel, Integer> {
    List<Aluguel> findAll();
    Aluguel save(Aluguel aluguel);
    void deleteAll();
    boolean existsById(Integer id);
    List<Aluguel> findByCliente_Numero(Integer id);
}
