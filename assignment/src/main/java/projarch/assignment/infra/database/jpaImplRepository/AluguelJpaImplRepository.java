package projarch.assignment.infra.database.jpaImplRepository;

import java.util.List;

import org.springframework.stereotype.Repository;

import projarch.assignment.infra.database.IJpaRepository.IAluguelJpaRepository;
import projarch.assignment.adapters.IMapper.IAlugueisMapper;
import projarch.assignment.domain.models.AluguelModel;
import projarch.assignment.adapters.repository.IAluguelRepository;


@Repository
public class AluguelJpaImplRepository implements IAluguelRepository {
    private IAluguelJpaRepository repository;
    private IAlugueisMapper alugueisMapper;


    public AluguelJpaImplRepository(IAluguelJpaRepository repository, IAlugueisMapper alugueisMapper){
        this.repository = repository;
        this.alugueisMapper = alugueisMapper;

    }

    @Override
    public List<AluguelModel> getAllAlugueis() {
        return alugueisMapper.listEntityModel(repository.findAll());
    }

    @Override
    public boolean validaAluguel(Integer id){
        return repository.existsById(id);
    }
}

