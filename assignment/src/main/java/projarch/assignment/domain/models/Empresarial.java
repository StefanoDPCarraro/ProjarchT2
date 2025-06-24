package projarch.assignment.domain.models;

public class Empresarial extends Cliente{
    private String nomeFantasia;
    private String cnpj;

    public Empresarial(Integer numero, String nome, String endereço, String nomeFantasia, String cnpj) {
        super(numero, nome, endereço);
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}