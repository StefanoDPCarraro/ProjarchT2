package projarch.assignment.application.validator;

import projarch.assignment.application.dto.request.CreateAluguelDTO;

public class AluguelValidator {
    public static boolean isValid(CreateAluguelDTO dto){

        // Validação dos campos obrigatórios
        if (dto == null) {
            throw new IllegalArgumentException("DTO não pode ser nulo.");
        }

        if(dto.getId() == null || dto.getId() < 0){
            throw new IllegalArgumentException("Id do aluguel não pode ser vazio ou negativo.");
        }
        if (dto.getPeriodo() == null || dto.getPeriodo() < 0) {
            throw new IllegalArgumentException("Periodo não pode ser vazio.");
        }
        if (dto.getCliente() == null || dto.getCliente() < 0) {
            throw new IllegalArgumentException("Cliente não pode ser vazio.");
        }
        if (dto.getJogo() == null || dto.getJogo() < 0) {
            throw new IllegalArgumentException("Jogo não pode ser vazio.");
        }
        if (dto.getDataInicial() == null) {
            throw new IllegalArgumentException("Data Inicial não pode ser vazio.");
        }
        return true;  // Se todas as validações passarem, retorna true
    }

}   
