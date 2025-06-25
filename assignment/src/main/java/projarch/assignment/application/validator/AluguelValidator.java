package projarch.assignment.application.validator;

import java.util.Date;
import java.util.List;

import projarch.assignment.application.dto.request.CreateAluguelDTO;
import projarch.assignment.application.dto.response.AluguelDTO;

public class AluguelValidator {
    public static boolean isValid(CreateAluguelDTO dto, List<AluguelDTO> alugueis) {

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
        if (isBooked(dto, alugueis)) {
            return false; // Se já está reservado, retorna false
        }
        return true;  // Se todas as validações passarem, retorna true
    }

    private static boolean isBooked(CreateAluguelDTO dto, List<AluguelDTO> alugueis) {
        if (alugueis == null || alugueis.isEmpty()) {
            return false; // Se não houver aluguéis, não está reservado
        }
        Date dataInicial = dto.getDataInicial();
        Date dataFinal = new Date(dataInicial.getTime() + (dto.getPeriodo() * 24 * 60 * 60 * 1000)); // Calcula a data final

        for( AluguelDTO aluguel : alugueis) {
            Date aluguelDataInicial = aluguel.getDataInicial();
            Date aluguelDataFinal = new Date(aluguelDataInicial.getTime() + (aluguel.getPeriodo() * 24 * 60 * 60 * 1000)); // Calcula a data final do aluguel

            // Verifica se as datas se sobrepõem
            if ((dataInicial.before(aluguelDataFinal) && dataFinal.after(aluguelDataInicial)) ||
                (dataInicial.equals(aluguelDataInicial) || dataFinal.equals(aluguelDataFinal))) {
                return true; // Está reservado
            }
        }
        return false; // Não está reservado
    }

}   
