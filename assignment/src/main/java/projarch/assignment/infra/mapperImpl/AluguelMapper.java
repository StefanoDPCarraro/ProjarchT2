package projarch.assignment.infra.mapperImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import projarch.assignment.adapters.IMapper.IAlugueisMapper;
import projarch.assignment.application.dto.request.CreateAluguelDTO;
import projarch.assignment.application.dto.response.AluguelDTO;
import projarch.assignment.domain.models.AluguelModel;
import projarch.assignment.domain.models.Cliente;
import projarch.assignment.domain.models.JogoModel;
import projarch.assignment.infra.database.entity.Aluguel;

@Component
public class AluguelMapper implements IAlugueisMapper {
    private ClienteMapper clienteMapper;
    private JogosMapper jogoMapper;

    public AluguelMapper(ClienteMapper clienteMapper, JogosMapper jogoMapper) {
        this.clienteMapper = clienteMapper;
        this.jogoMapper = jogoMapper;
    }


    @Override
    public AluguelDTO modelToDTO(AluguelModel aluguelModel) {
        return new AluguelDTO(
                aluguelModel.getId(),
                aluguelModel.getPeriodo(),
                aluguelModel.getDataInicial(),
                clienteMapper.toResponseDTO(aluguelModel.getCliente()),
                jogoMapper.modelToDTO(aluguelModel.getJogo())
        );
    }

    @Override
    public List<AluguelDTO> listModelToDTO(List<AluguelModel> alugueisModel) {
        return alugueisModel.stream()
                .map(this::modelToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AluguelModel entityToModel(Aluguel aluguel) {
        return new AluguelModel(
                aluguel.getId(),
                aluguel.getPeriodo(),
                aluguel.getDataInicial(),
                clienteMapper.toDomain(aluguel.getCliente()),
                jogoMapper.entityToModel(aluguel.getJogo())
        );
    }

    @Override
    public List<AluguelModel> listEntityModel(List<Aluguel> alugueis) {
        return alugueis.stream()
                .map(aluguel -> new AluguelModel(
                        aluguel.getId(),
                        aluguel.getPeriodo(),
                        aluguel.getDataInicial(),
                        clienteMapper.toDomain(aluguel.getCliente()),
                        jogoMapper.entityToModel(aluguel.getJogo())
                ))
                .collect(Collectors.toList());
    }
    @Override
    public Aluguel toEntity(AluguelModel domain){
        if (domain == null) {
            return null;
        }
        return new Aluguel(
            domain.getId(),
            domain.getDataInicial(),
            domain.getPeriodo(),
            clienteMapper.toEntity(domain.getCliente()),
            jogoMapper.modelToEntity(domain.getJogo())
        );
        
    }
    @Override
    public AluguelModel toDomain(Aluguel entity){
        if (entity == null) {
            return null;
        }
        return new AluguelModel(
                entity.getId(),
                entity.getPeriodo(),
                entity.getDataInicial(),
                clienteMapper.toDomain(entity.getCliente()),
                jogoMapper.entityToModel(entity.getJogo())
                );
    }

    @Override
    public AluguelModel toDomain(CreateAluguelDTO aluguelDTO, Cliente cliente, JogoModel jogo){
        if (aluguelDTO == null) {
            return null;
        }
        return new AluguelModel(
                aluguelDTO.getId(),
                aluguelDTO.getPeriodo(),
                aluguelDTO.getDataInicial(),
                cliente,
                jogo
                );
    }
}
