package projarch.assignment.adapters.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projarch.assignment.application.dto.response.AluguelDTO;
import projarch.assignment.application.useCase.ListaAlugueisByClienteUC;
import projarch.assignment.application.useCase.ValidaClienteUC;
import projarch.assignment.application.useCase.ValidaJogoUC;

@RestController
@RequestMapping("/acmegames")
public class AcmeGamesController {
    private final ValidaClienteUC validaClienteUC;
    private final ValidaJogoUC validaJogoUC;
    private final ListaAlugueisByClienteUC listaAlugueisByClienteUC;

    public AcmeGamesController(ValidaClienteUC validaClienteUC, ValidaJogoUC validaJogoUC, ListaAlugueisByClienteUC listaAlugueisByClienteUC) {
        this.validaClienteUC = validaClienteUC;
        this.validaJogoUC = validaJogoUC;
        this.listaAlugueisByClienteUC = listaAlugueisByClienteUC;
    }

    @PostMapping("/validacliente")
    public ResponseEntity<Boolean> validaCliente(@RequestBody Integer id){
        return ResponseEntity.ok(validaClienteUC.execute(id));
    }

    @PostMapping("/validajogo")
    public ResponseEntity<Boolean> validaJogo(@RequestBody int id){
        return ResponseEntity.ok(validaJogoUC.execute(id));
    }

    @GetMapping("cliente/aluguel/{numero}")
    public ResponseEntity<List<AluguelDTO>> listaAlugueisPorCliente(@PathVariable int numero){
        return ResponseEntity.ok(listaAlugueisByClienteUC.execute(numero));
    }
}
