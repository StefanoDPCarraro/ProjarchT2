package projarch.assignment.infra.mapperImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import projarch.assignment.adapters.IMapper.IAlugueisMapper;
import projarch.assignment.application.dto.response.AluguelDTO;
import projarch.assignment.domain.models.AluguelModel;
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
}
