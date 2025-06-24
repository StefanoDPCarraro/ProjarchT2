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
        if(jogoModel instanceof JogoEletronicoModel){
            JogoEletronico jogo = new JogoEletronico();
            jogo.setCodigo(jogoModel.getCodigo());
            jogo.setNome(jogoModel.getNome());
            jogo.setValorBase(jogoModel.getValorBase());
            jogo.setPlataforma(((JogoEletronicoModel) jogoModel).getPlataforma());
            jogo.setTipo(((JogoEletronicoModel) jogoModel).getTipoEletronico());
            jogoEntity = repository.save(jogo);
        } else if(jogoModel instanceof JogoMesaModel){
            JogoMesa jogo = new JogoMesa();
            jogo.setCodigo(jogoModel.getCodigo());
            jogo.setNome(jogoModel.getNome());
            jogo.setValorBase(jogoModel.getValorBase());
            jogo.setTipo(((JogoMesaModel) jogoModel).getTipoMesa());
            jogo.setNumeroPecas(((JogoMesaModel) jogoModel).getNumeroPecas());
            jogoEntity = repository.save(jogo);
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
