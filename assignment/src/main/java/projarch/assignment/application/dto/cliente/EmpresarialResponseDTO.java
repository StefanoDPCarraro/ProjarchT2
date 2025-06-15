package projarch.assignment.application.dto.cliente;

public class EmpresarialResponseDTO extends ClienteResponseDTO{
    private String nomeFantasia;
    private String cnpj;

    public EmpresarialResponseDTO(Integer numero, String nome, String endereço, String nomeFantasia, String cnpj) {
        super(numero, nome, endereço);
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

}
