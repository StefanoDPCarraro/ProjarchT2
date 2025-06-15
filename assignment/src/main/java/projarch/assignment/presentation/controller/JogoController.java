package projarch.assignment.presentation.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projarch.assignment.application.dto.jogo.JogoDTO;

@RestController
@RequestMapping("/acmegames/cadastro")
public class JogoController {
    @GetMapping("/listajogos")
    public List<JogoDTO> listaJogos() {
        
        return null;
    }
}
