package projarch.assignment.domain.models;

public class Individual extends Cliente{
    private String cpf;

    public Individual(Integer numero, String nome, String endereço, String cpf) {
        super(numero, nome, endereço);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    
}
