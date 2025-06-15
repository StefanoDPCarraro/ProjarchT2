package projarch.assignment.domain.models.jogo;

import projarch.assignment.domain.enums.EnumTipoEletronico;

public class JogoEletronicoModel extends JogoModel {
    private EnumTipoEletronico tipoEletronico;
    private String plataforma;

    public JogoEletronicoModel(int codigo, String nome, double valorBase, EnumTipoEletronico tipoEletronico, String plataforma) {
        super(codigo, nome, valorBase);
        this.tipoEletronico = tipoEletronico;
        this.plataforma = plataforma;
    }

    public EnumTipoEletronico getTipoEletronico() {
        return tipoEletronico;
    }

    public void setTipoEletronico(EnumTipoEletronico tipoEletronico) {
        this.tipoEletronico = tipoEletronico;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    @Override
    public double calcularValorAluguel() {
        if(getTipoEletronico() == EnumTipoEletronico.AVENTURA){
            return getValorBase() * 1.05;
        }
        else if(getTipoEletronico() == EnumTipoEletronico.ESTRATEGIA){
            return getValorBase() * 1.15;
        }
        // !aventura && !estrategia -> simulação
        else{
            return getValorBase() * 1.25;
        }
    }

    
}
