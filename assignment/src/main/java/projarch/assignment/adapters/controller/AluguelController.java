package projarch.assignment.adapters.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projarch.assignment.application.dto.response.AluguelDTO;
import projarch.assignment.application.useCase.GetAllAlugueisUC;
import projarch.assignment.application.useCase.ValidaAluguelUC;

@RestController
@RequestMapping("/acmegames/cadastro")
public class AluguelController {
    private final GetAllAlugueisUC getAllAlugueisUC;
    private final ValidaAluguelUC validaAluguelUC;

    public AluguelController(GetAllAlugueisUC getAllAlugueisUC, ValidaAluguelUC validaAluguelUC){
        this.getAllAlugueisUC = getAllAlugueisUC;
        this.validaAluguelUC = validaAluguelUC;
    }

    @GetMapping("/listaalugueis")
    public List<AluguelDTO> listaAlugueis() {
        return getAllAlugueisUC.execute();
    }

    @PostMapping("/validaaluguel")
    public ResponseEntity<Boolean> validaAluguel(@RequestBody Integer id){
        return ResponseEntity.ok(validaAluguelUC.execute(id));
    }
    
}
