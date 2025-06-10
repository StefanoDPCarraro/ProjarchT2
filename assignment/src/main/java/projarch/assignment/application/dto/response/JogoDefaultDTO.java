package projarch.assignment.application.dto.response;

public class JogoDefaultDTO {
    private int codigo;
    private String nome;
    private double valorBase;
    private String tipo;
    private double valorAluguel;

    public JogoDefaultDTO(int codigo, String nome, double valorBase, String tipo, double valorAluguel) {
        this.codigo = codigo;
        this.nome = nome;
        this.valorBase = valorBase;
        this.tipo = tipo;
        this.valorAluguel = valorAluguel;
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

    public String getTipo() {
        return tipo;
    }

    public double getValorAluguel() {
        return valorAluguel;
    }
}