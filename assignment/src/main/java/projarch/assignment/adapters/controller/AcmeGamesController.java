package projarch.assignment.adapters.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projarch.assignment.application.useCase.ValidaClienteUC;
import projarch.assignment.application.useCase.ValidaJogoUC;

@RestController
@RequestMapping("/acmegames")
public class AcmeGamesController {
    private final ValidaClienteUC validaClienteUC;
    private final ValidaJogoUC validaJogoUC;

    public AcmeGamesController(ValidaClienteUC validaClienteUC, ValidaJogoUC validaJogoUC) {
        this.validaClienteUC = validaClienteUC;
        this.validaJogoUC = validaJogoUC;
    }

    @PostMapping("/validacliente")
    public ResponseEntity<Boolean> validaCliente(@RequestBody Integer id){
        return ResponseEntity.ok(validaClienteUC.execute(id));
    }

    @PostMapping("/validajogo")
    public ResponseEntity<Boolean> validaJogo(@RequestBody int id){
        return ResponseEntity.ok(validaJogoUC.execute(id));
    }
}
