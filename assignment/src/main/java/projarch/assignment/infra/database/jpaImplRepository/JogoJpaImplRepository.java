package projarch.assignment.infra.database.jpaImplRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import projarch.assignment.adapters.IMapper.IJogosMapper;
import projarch.assignment.adapters.repository.IJogoRepository;
import projarch.assignment.domain.models.JogoEletronicoModel;
import projarch.assignment.domain.models.JogoMesaModel;
import projarch.assignment.domain.models.JogoModel;
import projarch.assignment.infra.database.IJpaRepository.IJogoJpaRepository;
import projarch.assignment.infra.database.entity.Jogo;
import projarch.assignment.infra.database.entity.JogoEletronico;
import projarch.assignment.infra.database.entity.JogoMesa;

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
    public JogoModel save(JogoModel jogoModel) {
        Jogo jogoEntity = null;
        System.out.println("Saving jogoModel: " + jogoModel.toString());
        if(jogoModel instanceof JogoEletronicoModel){
            JogoEletronico jogoEl = new JogoEletronico();
            jogoEl.setCodigo(jogoModel.getCodigo());
            jogoEl.setNome(jogoModel.getNome());
            jogoEl.setValorBase(jogoModel.getValorBase());
            jogoEl.setPlataforma(((JogoEletronicoModel) jogoModel).getPlataforma());
            jogoEl.setTipo(((JogoEletronicoModel) jogoModel).getTipoEletronico());
            jogoEntity = repository.save(jogoEl);
        } else if(jogoModel instanceof JogoMesaModel){
            JogoMesa jogoMe = new JogoMesa();
            jogoMe.setCodigo(jogoModel.getCodigo());
            jogoMe.setNome(jogoModel.getNome());
            jogoMe.setValorBase(jogoModel.getValorBase());
            jogoMe.setTipo(((JogoMesaModel) jogoModel).getTipoMesa());
            jogoMe.setNumeroPecas(((JogoMesaModel) jogoModel).getNumeroPecas());
            jogoEntity = repository.save(jogoMe);
        } else{
            return null; // or throw an exception if needed
        }
        return jogosMapper.entityToModel(jogoEntity);
    }

    @Override
    public boolean existsById(int id){
        return repository.existsById(id);
    }

    @Override
    public Optional<JogoModel> findById(int id){
        return repository.findById(id)
        .map(jogosMapper::entityToModel);
    }
}
