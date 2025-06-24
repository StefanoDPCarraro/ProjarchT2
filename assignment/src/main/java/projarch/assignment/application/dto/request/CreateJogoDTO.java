package projarch.assignment.application.dto.request;


public class CreateJogoDTO {
    private int codigo;
    private String nome;
    private double valorBase;
    private String tipo;
    private String plataforma;
    private Integer numeroPecas;

    public CreateJogoDTO(int codigo, String nome, double valorBase, String tipo, String plataforma, Integer numeroPecas) {
        this.nome = nome;
        this.valorBase = valorBase;
        this.tipo = tipo;
        this.plataforma = plataforma;
        this.numeroPecas = numeroPecas;
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

    public String getPlataforma() {
        return plataforma;
    }

    public Integer getNumeroPecas() {
        return numeroPecas;
    }

}