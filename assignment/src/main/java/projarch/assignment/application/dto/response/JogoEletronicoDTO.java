package projarch.assignment.application.dto.response;

public class JogoEletronicoDTO implements JogoDTO {
    private String tipoEletronico;
    private String plataforma;
    private int codigo;
    private String nome;
    private double valorBase;
    private double valorAluguel;

    public JogoEletronicoDTO(int codigo, String nome, double valorBase, String tipoEletronico, String plataforma, double valorAluguel) {
        this.codigo = codigo;
        this.nome = nome;
        this.valorBase = valorBase;
        this.tipoEletronico = tipoEletronico;
        this.plataforma = plataforma;
        this.valorAluguel = valorAluguel;
    }

    public String getTipoEletronico() {
        return tipoEletronico;
    }
    public String getPlataforma() {
        return plataforma;
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
