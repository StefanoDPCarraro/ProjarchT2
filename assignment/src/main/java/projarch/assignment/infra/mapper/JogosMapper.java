package projarch.assignment.infra.mapper;

import java.util.List;

import projarch.assignment.application.dto.response.JogoDTO;
import projarch.assignment.application.dto.response.JogoEletronicoDTO;
import projarch.assignment.application.dto.response.JogoMesaDTO;
import projarch.assignment.domain.models.JogoEletronicoModel;
import projarch.assignment.domain.models.JogoMesaModel;
import projarch.assignment.domain.models.JogoModel;

public class JogosMapper {

    public static JogoDTO modelToDTO(JogoModel jogoModel){
        if(jogoModel instanceof JogoEletronicoModel){
            return new JogoEletronicoDTO(
                jogoModel.getCodigo(),
                jogoModel.getNome(),
                jogoModel.getValorBase(),
                ((JogoEletronicoModel) jogoModel).getTipoEletronico().toString(),
                ((JogoEletronicoModel) jogoModel).getPlataforma(),
                jogoModel.calcularValorAluguel()
            );
        }
        if(jogoModel instanceof JogoMesaModel){
            return new JogoMesaDTO(
                jogoModel.getCodigo(),
                jogoModel.getNome(),
                jogoModel.getValorBase(),
                ((JogoMesaModel) jogoModel).getTipoMesa().toString(),
                ((JogoMesaModel) jogoModel).getNumeroPecas(),
                jogoModel.calcularValorAluguel()
            );
        }
        return null;
    }

    public static List<JogoDTO> listModelToDTO(List<JogoModel> jogosModel){
        return jogosModel.stream()
            .map(JogosMapper::modelToDTO)
            .toList();
    }

}
