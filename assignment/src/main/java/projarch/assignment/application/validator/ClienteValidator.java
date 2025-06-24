package projarch.assignment.application.validator;

import projarch.assignment.application.dto.request.CreateClienteDTO;

public class ClienteValidator {
    public static boolean isValid(CreateClienteDTO dto){

        // Validação dos campos obrigatórios
        if (dto == null) {
            throw new IllegalArgumentException("DTO não pode ser nulo.");
        }

        if(dto.getNumero() == null || dto.getNumero() < 0){
            throw new IllegalArgumentException("Id do cliente não pode ser vazio ou negativo.");
        }
        if (dto.getNome() == null || dto.getNome().isEmpty()) {
            throw new IllegalArgumentException("Nome do cliente não pode ser vazio.");
        }
        if (dto.getEndereço() == null || dto.getEndereço().isEmpty()) {
            throw new IllegalArgumentException("Endereço do cliente não pode ser vazio.");
        }
        if (dto.getTipo() == null || dto.getTipo().isEmpty()) {
            throw new IllegalArgumentException("Tipo de cliente não pode ser vazio.");
        }
 
        // Validação do tipo de cliente (Individual ou Empresarial)
        if ("individual".equalsIgnoreCase(dto.getTipo())) {

            // Validação de CPF para cliente individual
            if (dto.getCpf() == null || dto.getCpf().isEmpty()) {
                throw new IllegalArgumentException("CPF é obrigatório para clientes individuais.");
            }
            if (!isValidCpf(dto.getCpf())) {
                throw new IllegalArgumentException("CPF inválido.");
            }

        } else if ("empresarial".equalsIgnoreCase(dto.getTipo())) {
            // Validação de CNPJ para cliente empresarial
            if (dto.getCnpj() == null || dto.getCnpj().isEmpty()) {
                throw new IllegalArgumentException("CNPJ é obrigatório para clientes empresariais.");
            }
            if (!isValidCnpj(dto.getCnpj())) {
                throw new IllegalArgumentException("CNPJ inválido.");
            }

            // Validação de nome fantasia para cliente empresarial
            if (dto.getNomeFantasia() == null || dto.getNomeFantasia().isEmpty()) {
                throw new IllegalArgumentException("Nome fantasia é obrigatório para clientes empresariais.");
            }

        } else {
            throw new IllegalArgumentException("Tipo de cliente inválido. Deve ser 'individual' ou 'empresarial'.");
        }

        return true;  // Se todas as validações passarem, retorna true
    }

    // Validação de CPF
    private static boolean isValidCpf(String cpf) {
        return cpf != null && cpf.matches("\\d{11}");
    }

    // Validação de CNPJ
    private static boolean isValidCnpj(String cnpj) {
        return cnpj != null && cnpj.matches("\\d{14}");
    }
}
