package projarch.assignment.application.dto.response;

public class JogoMesaDTO implements JogoDTO {
    private String tipoMesa;
    private int numeroPecas;
    private int codigo;
    private String nome;
    private double valorBase;
    private double valorAluguel;

    public JogoMesaDTO(int codigo, String nome, double valorBase, String tipoMesa, int numeroPecas, double valorAluguel) {
        this.codigo = codigo;
        this.nome = nome;
        this.valorBase = valorBase;
        this.tipoMesa = tipoMesa;
        this.numeroPecas = numeroPecas;
        this.valorAluguel = valorAluguel;
    }

    public String getTipoMesa() {
        return tipoMesa;
    }

    public int getNumeroPecas() {
        return numeroPecas;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getValorBase() {
        return valorBase;
    }

    public double getValorAluguel() {
        return valorAluguel;
    }
}
