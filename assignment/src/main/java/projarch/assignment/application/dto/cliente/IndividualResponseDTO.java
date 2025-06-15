package projarch.assignment.application.dto.cliente;

public class IndividualResponseDTO extends ClienteResponseDTO{
    private String cpf;

    public IndividualResponseDTO(Integer numero, String nome, String endereço, String cpf) {
        super(numero, nome, endereço);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }
}
