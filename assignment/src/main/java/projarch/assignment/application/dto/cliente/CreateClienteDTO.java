package projarch.assignment.application.dto.cliente;

public class CreateClienteDTO {
    String nome;
    String endereço;
    String tipo;
    String cnpj;
    String cpf;
    String nomeFantasia;
    
    public CreateClienteDTO(String nome, String endereço, String tipo, String cpf, String cnpj, String nomeFantasia) {
        this.nome = nome;
        this.endereço = endereço;
        this.tipo = tipo;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    
}
