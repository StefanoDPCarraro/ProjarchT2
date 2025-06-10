package projarch.assignment.domain.models;

import projarch.assignment.domain.enums.EnumTipoMesa;

public class JogoMesaModel extends JogoModel{
    private EnumTipoMesa tipoMesa;
    private int numeroPecas;

    public JogoMesaModel(int codigo, String nome, double valorBase, EnumTipoMesa tipoMesa, int numeroPecas) {
        super(codigo, nome, valorBase);
        this.tipoMesa = tipoMesa;
        this.numeroPecas = numeroPecas;
    }

    public EnumTipoMesa getTipoMesa() {
        return tipoMesa;
    }

    public void setTipoMesa(EnumTipoMesa tipoMesa) {
        this.tipoMesa = tipoMesa;
    }

    public int getNumeroPecas() {
        return numeroPecas;
    }

    public void setNumeroPecas(int numeroPecas) {
        this.numeroPecas = numeroPecas;
    }

    @Override
    public double calcularValorAluguel() {
        if(tipoMesa == EnumTipoMesa.CARTAS){
            return getValorBase() * 1.2;
        }
        // !cartas -> tabuleiro
        return getValorBase() * getNumeroPecas();
    }
}
