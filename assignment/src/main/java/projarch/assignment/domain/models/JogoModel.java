package projarch.assignment.domain.models;

public abstract class JogoModel {
    private int codigo;
    private String nome;
    private double valorBase;
    
    protected JogoModel(int codigo, String nome, double valorBase) {
        this.codigo = codigo;
        this.nome = nome;
        this.valorBase = valorBase;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getValorBase() {
        return valorBase;
    }
    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
    }
    
    public abstract double calcularValorAluguel();

    @Override
    public String toString() {
        return "JogoModel{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", valorBase=" + valorBase +
                '}';
    }
}
