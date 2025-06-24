package projarch.assignment.infra.database.jpaImplRepository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import projarch.assignment.adapters.IMapper.IAlugueisMapper;
import projarch.assignment.adapters.repository.IAluguelRepository;
import projarch.assignment.domain.models.AluguelModel;
import projarch.assignment.infra.database.IJpaRepository.IAluguelJpaRepository;


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

    @Override
    public List<AluguelModel> findByClienteId(Integer idCliente) {
        return repository.findByCliente_Numero(idCliente).stream()
        .map(alugueisMapper::entityToModel)
        .collect(Collectors.toList());
    }

    @Override
    public List<AluguelModel> findByJogoId(Integer idJogo) {
        return repository.findByJogo_Codigo(idJogo).stream()
        .map(alugueisMapper::entityToModel)
        .collect(Collectors.toList());
    }
}

