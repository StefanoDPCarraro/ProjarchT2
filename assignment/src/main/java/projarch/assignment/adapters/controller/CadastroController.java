package projarch.assignment.adapters.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projarch.assignment.application.dto.response.AluguelDTO;
import projarch.assignment.application.dto.response.JogoDTO;
import projarch.assignment.application.useCase.GetAllAlugueisUC;
import projarch.assignment.application.useCase.GetAllJogosUC;
import projarch.assignment.application.useCase.ValidaAluguelUC;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/acmegames/cadastro")
public class CadastroController {
    private final GetAllAlugueisUC getAllAlugueisUC;
    private final ValidaAluguelUC validaAluguelUC;
    private final GetAllJogosUC getAllJogosUC;

    public CadastroController(GetAllAlugueisUC getAllAlugueisUC, ValidaAluguelUC validaAluguelUC, GetAllJogosUC getAllJogosUC) {
        this.getAllAlugueisUC = getAllAlugueisUC;
        this.validaAluguelUC = validaAluguelUC;
        this.getAllJogosUC = getAllJogosUC;
    }

    @GetMapping("/listaalugueis")
    public List<AluguelDTO> listaAlugueis() {
        return getAllAlugueisUC.execute();
    }

    @GetMapping("/validaaluguel")
    public Boolean validaAluguel(@RequestBody Integer id) {
        return validaAluguelUC.execute(id);
    }

    @GetMapping("/listajogos")
    public List<JogoDTO> listaJogos(){
        return getAllJogosUC.execute();
    }
    
}
