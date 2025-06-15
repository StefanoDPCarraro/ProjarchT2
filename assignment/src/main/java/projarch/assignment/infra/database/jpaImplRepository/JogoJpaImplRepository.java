package projarch.assignment.infra.database.jpaImplRepository;

import java.util.List;

import org.springframework.stereotype.Repository;

import projarch.assignment.domain.models.JogoModel;
import projarch.assignment.domain.repository.IJogoRepository;
import projarch.assignment.infra.database.IJpaRepository.IJogoJpaRepository;
import projarch.assignment.infra.mapper.JogosMapper;

@Repository
public class JogoJpaImplRepository implements IJogoRepository {
    private IJogoJpaRepository repository;

    public JogoJpaImplRepository(IJogoJpaRepository repository){
        this.repository = repository;
    }

    @Override
    public List<JogoModel> getAllJogos() {
        return JogosMapper.listEntityToModel(repository.findAll());
    }
}
