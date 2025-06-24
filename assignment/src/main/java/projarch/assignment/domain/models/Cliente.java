package projarch.assignment.domain.models;

public abstract class Cliente {
    private Integer numero;
    private String nome;
    private String endereço;
    
    public Cliente(Integer numero, String nome, String endereço) {
        this.numero = numero;
        this.nome = nome;
        this.endereço = endereço;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

}

