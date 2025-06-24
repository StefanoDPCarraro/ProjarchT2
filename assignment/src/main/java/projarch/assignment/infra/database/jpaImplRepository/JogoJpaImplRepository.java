package projarch.assignment.infra.database.jpaImplRepository;

import java.util.List;

import org.springframework.stereotype.Repository;

import projarch.assignment.adapters.IMapper.IJogosMapper;
import projarch.assignment.adapters.repository.IJogoRepository;
import projarch.assignment.domain.models.JogoModel;
import projarch.assignment.infra.database.IJpaRepository.IJogoJpaRepository;

@Repository
public class JogoJpaImplRepository implements IJogoRepository {
    private IJogoJpaRepository repository;
    private IJogosMapper jogosMapper;

    public JogoJpaImplRepository(IJogoJpaRepository repository, IJogosMapper jogosMapper){
        this.repository = repository;
        this.jogosMapper = jogosMapper;
    }

    @Override
    public List<JogoModel> getAllJogos() {
        return jogosMapper.listEntityToModel(repository.findAll());
    }

    @Override
    public boolean salvaJogo(JogoModel jogo) {
        return repository.save(jogosMapper.modelToEntity(jogo)) != null;
    }

    @Override
    public boolean existsById(int id){
        return repository.existsById(id);
    }
}
