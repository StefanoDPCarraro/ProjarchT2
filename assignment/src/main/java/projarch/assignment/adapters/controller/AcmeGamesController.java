package projarch.assignment.adapters.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projarch.assignment.application.useCase.ValidaClienteUC;

@RestController
@RequestMapping("/acmegames")
public class AcmeGamesController {
    private final ValidaClienteUC validaClienteUC;

    public AcmeGamesController(ValidaClienteUC validaClienteUC) {
        this.validaClienteUC = validaClienteUC;
    }

    @PostMapping("/validacliente")
    public ResponseEntity<Boolean> validaCliente(@RequestBody Integer id){
        return ResponseEntity.ok(validaClienteUC.execute(id));
    }
}
