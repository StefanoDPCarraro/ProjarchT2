package projarch.assignment.infra.mapperImpl;

import java.util.List;

import org.springframework.stereotype.Component;

import projarch.assignment.adapters.IMapper.IJogosMapper;
import projarch.assignment.application.dto.response.JogoDTO;
import projarch.assignment.application.dto.response.JogoEletronicoDTO;
import projarch.assignment.application.dto.response.JogoMesaDTO;
import projarch.assignment.domain.enums.EnumTipoEletronico;
import projarch.assignment.domain.enums.EnumTipoMesa;
import projarch.assignment.domain.models.JogoEletronicoModel;
import projarch.assignment.domain.models.JogoMesaModel;
import projarch.assignment.domain.models.JogoModel;
import projarch.assignment.infra.database.entity.Jogo;
import projarch.assignment.infra.database.entity.JogoEletronico;
import projarch.assignment.infra.database.entity.JogoMesa;

@Component
public class JogosMapper implements IJogosMapper {

    public JogoDTO modelToDTO(JogoModel jogoModel) {
        if (jogoModel instanceof JogoEletronicoModel) {
            return new JogoEletronicoDTO(
                    jogoModel.getCodigo(),
                    jogoModel.getNome(),
                    jogoModel.getValorBase(),
                    ((JogoEletronicoModel) jogoModel).getTipoEletronico().toString(),
                    ((JogoEletronicoModel) jogoModel).getPlataforma(),
                    jogoModel.calcularValorAluguel());
        }
        if (jogoModel instanceof JogoMesaModel) {
            return new JogoMesaDTO(
                    jogoModel.getCodigo(),
                    jogoModel.getNome(),
                    jogoModel.getValorBase(),
                    ((JogoMesaModel) jogoModel).getTipoMesa().toString(),
                    ((JogoMesaModel) jogoModel).getNumeroPecas(),
                    jogoModel.calcularValorAluguel());
        }
        return null;
    }

    public List<JogoDTO> listModelToDTO(List<JogoModel> jogosModel) {
        return jogosModel.stream()
                .map(this::modelToDTO)
                .toList();
    }

    public JogoModel entityToModel(Jogo jogo) {
        if (jogo instanceof JogoEletronico) {
            return new JogoEletronicoModel(
                    jogo.getCodigo(),
                    jogo.getNome(),
                    jogo.getValorBase(),
                    ((JogoEletronico) jogo).getTipo(),
                    ((JogoEletronico) jogo).getPlataforma());
        }
        if (jogo instanceof JogoMesa) {
            return new JogoMesaModel(
                    jogo.getCodigo(),
                    jogo.getNome(),
                    jogo.getValorBase(),
                    ((JogoMesa) jogo).getTipo(),
                    ((JogoMesa) jogo).getNumeroPecas());
        }
        return null;
    }

    public List<JogoModel> listEntityToModel(List<Jogo> jogos) {
        return jogos.stream()
                .map(this::entityToModel)
                .toList();
    }

    public Jogo modelToEntity(JogoModel jogoModel) {
        if (jogoModel instanceof JogoEletronicoModel) {
            return new JogoEletronico(
                    ((JogoEletronicoModel) jogoModel).getTipoEletronico(),
                    ((JogoEletronicoModel) jogoModel).getPlataforma(),
                    jogoModel.getCodigo(),
                    jogoModel.getNome(),
                    jogoModel.getValorBase());
        }
        if (jogoModel instanceof JogoMesaModel) {
            return new JogoMesa(
                    ((JogoMesaModel) jogoModel).getTipoMesa(),
                    ((JogoMesaModel) jogoModel).getNumeroPecas(),
                    jogoModel.getCodigo(),
                    jogoModel.getNome(),
                    jogoModel.getValorBase());
        }
        return null;
    }

    public List<Jogo> listModelToEntity(List<JogoModel> jogosModel) {
        return jogosModel.stream()
                .map(this::modelToEntity)
                .toList();
    }

    public JogoModel dtoToModel(JogoDTO jogoDTO) {
        if (jogoDTO instanceof JogoEletronicoDTO) {
            return new JogoEletronicoModel(
                    jogoDTO.getCodigo(),
                    jogoDTO.getNome(),
                    jogoDTO.getValorBase(),
                    EnumTipoEletronico.fromString(((JogoEletronicoDTO) jogoDTO).getTipoEletronico()),
                    ((JogoEletronicoDTO) jogoDTO).getPlataforma());
        }
        if (jogoDTO instanceof JogoMesaDTO) {
            return new JogoMesaModel(
                    jogoDTO.getCodigo(),
                    jogoDTO.getNome(),
                    jogoDTO.getValorBase(),
                    EnumTipoMesa.fromString(((JogoMesaDTO) jogoDTO).getTipoMesa()),
                    ((JogoMesaDTO) jogoDTO).getNumeroPecas());
        }
        return null;
    }

    public List<JogoModel> listDTOToModel(List<JogoDTO> jogosDTO) {
        return jogosDTO.stream()
                .map(this::dtoToModel)
                .toList();
    }
}
