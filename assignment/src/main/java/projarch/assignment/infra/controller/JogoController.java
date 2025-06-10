package projarch.assignment.infra.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/acmegames/cadastro")
public class JogoController {
    @GetMapping("/listajogos")
    public String listaJogos() {
        return "listajogos";
    }
}
