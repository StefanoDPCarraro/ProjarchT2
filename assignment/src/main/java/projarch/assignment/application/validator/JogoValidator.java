package projarch.assignment.application.validator;

import projarch.assignment.application.dto.request.CreateJogoDTO;

public class JogoValidator {
    private static final String[] tiposValidos = {"TABULEIRO", "CARTA", "AVENTURA", "ESTRATEGIA", "SIMULACAO"};
    public static boolean isValid(CreateJogoDTO createJogoDTO) {
        if (createJogoDTO == null) {
            return false;
        }

        if (createJogoDTO.getNome() == null  || createJogoDTO.getNome().isEmpty()) {
            return false;
        }

        if (createJogoDTO.getValorBase() <= 0) {
            return false;
        }

        if (createJogoDTO.getTipo() == null  || !isTipoValido(createJogoDTO.getTipo())) {
            return false;
        }

        if(createJogoDTO.getTipo().equalsIgnoreCase("TABULEIRO")  || createJogoDTO.getTipo().equalsIgnoreCase("CARTA")) {
            if (createJogoDTO.getNumeroPecas() == null){
                return false;
            }
        }

        if(createJogoDTO.getTipo().equalsIgnoreCase("AVENTURA")  || createJogoDTO.getTipo().equalsIgnoreCase("ESTRATEGIA") || createJogoDTO.getTipo().equalsIgnoreCase("SIMULACAO")) {
            if (createJogoDTO.getPlataforma() == null){
                return false;
            }
        }

        return true; // Se todas as validações passarem, retorna true
    }
    private static boolean isTipoValido(String tipo) {
        for (String tipoValido : tiposValidos) {
            if (tipoValido.equalsIgnoreCase(tipo)) {
                return true;
            }
        }
        return false;
    }
}