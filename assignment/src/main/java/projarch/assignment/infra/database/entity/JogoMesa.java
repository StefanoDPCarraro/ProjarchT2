package projarch.assignment.infra.database.entity;

import jakarta.persistence.Entity;
import projarch.assignment.domain.enums.EnumTipoMesa;

@Entity
public class JogoMesa extends Jogo{
    private EnumTipoMesa tipo;
    private int numeroPecas;
    public JogoMesa(){}
    public JogoMesa(EnumTipoMesa tipo, int numeroPecas, Integer codigo, String nome, double valorBase){
        super(codigo, nome, valorBase);
        this.tipo = tipo;
        this.numeroPecas = numeroPecas;
    }
    public EnumTipoMesa getTipo() {
        return tipo;
    }
    public void setTipo(EnumTipoMesa tipo) {
        this.tipo = tipo;
    }
    public int getNumeroPecas() {
        return numeroPecas;
    }
    public void setNumeroPecas(int numeroPecas) {
        this.numeroPecas = numeroPecas;
    }
}
