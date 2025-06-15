package projarch.assignment.infra.database.entity;

import jakarta.persistence.Entity;
import projarch.assignment.domain.enums.EnumTipoEletronico;

@Entity
public class JogoEletronico extends Jogo{
    private EnumTipoEletronico tipo;
    private String plataforma;
    public JogoEletronico(){}
    public JogoEletronico(EnumTipoEletronico tipo, String plataforma, Integer codigo, String nome, double valorBase){
        super(codigo, nome, valorBase);
        this.tipo = tipo;
        this.plataforma = plataforma;
    }
    public EnumTipoEletronico getTipo() {
        return tipo;
    }
    public void setTipo(EnumTipoEletronico tipo) {
        this.tipo = tipo;
    }
    public String getPlataforma() {
        return plataforma;
    }
    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }
}