package projarch.assignment.application.dto.response;

public abstract class ClienteResponseDTO {
    private Integer numero;
    private String nome;
    private String endereço;

    public ClienteResponseDTO(Integer numero, String nome, String endereço) {
        this.numero = numero;
        this.nome = nome;
        this.endereço = endereço;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereço() {
        return endereço;
    }

    
}

