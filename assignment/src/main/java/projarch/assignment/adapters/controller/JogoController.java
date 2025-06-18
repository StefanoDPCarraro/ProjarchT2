/*package projarch.assignment.adapters.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projarch.assignment.application.dto.response.JogoDTO;
import projarch.assignment.application.useCase.GetAllJogosUC;

@RestController
@RequestMapping("/acmegames/cadastro")
public class JogoController {

    private final GetAllJogosUC getAllJogosUC;

    public JogoController(GetAllJogosUC getAllJogosUC){
        this.getAllJogosUC = getAllJogosUC;
    }

    @GetMapping("/listajogos")
    public List<JogoDTO> listaJogos() {
        return getAllJogosUC.execute();
    }
}
*/