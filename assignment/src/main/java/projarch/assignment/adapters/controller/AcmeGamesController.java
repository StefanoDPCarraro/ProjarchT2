package projarch.assignment.adapters.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projarch.assignment.application.dto.response.AluguelDTO;
import projarch.assignment.application.useCase.CalculaPrecoFinalAluguelUC;
import projarch.assignment.application.useCase.CalculaPrecoJogoUC;
import projarch.assignment.application.useCase.ListaAlugueisByClienteUC;
import projarch.assignment.application.useCase.ListaAlugueisByJogoUC;
import projarch.assignment.application.useCase.ValidaAluguelUC;
import projarch.assignment.application.useCase.ValidaClienteUC;
import projarch.assignment.application.useCase.ValidaJogoUC;


@RestController
@RequestMapping("/acmegames")
public class AcmeGamesController {
    private final ValidaClienteUC validaClienteUC;
    private final ValidaJogoUC validaJogoUC;
    private final ValidaAluguelUC validaAluguelUC;
    private final ListaAlugueisByClienteUC listaAlugueisByClienteUC;
    private final ListaAlugueisByJogoUC listaAlugueisByJogoUC;
    private final CalculaPrecoJogoUC calculaPrecoJogoUC;
    private final CalculaPrecoFinalAluguelUC calculaPrecoFinalAluguelUC;

    public AcmeGamesController(ValidaClienteUC validaClienteUC, ValidaJogoUC validaJogoUC, ListaAlugueisByClienteUC listaAlugueisByClienteUC, ListaAlugueisByJogoUC listaAlugueisByJogoUC, CalculaPrecoJogoUC calculaPrecoJogoUC, CalculaPrecoFinalAluguelUC calculaPrecoFinalAluguelUC, ValidaAluguelUC validaAluguelUC) {
        this.validaClienteUC = validaClienteUC;
        this.validaJogoUC = validaJogoUC;
        this.listaAlugueisByClienteUC = listaAlugueisByClienteUC;
        this.listaAlugueisByJogoUC = listaAlugueisByJogoUC;
        this.calculaPrecoJogoUC = calculaPrecoJogoUC;
        this.calculaPrecoFinalAluguelUC = calculaPrecoFinalAluguelUC;
        this.validaAluguelUC = validaAluguelUC;
    }

    @PostMapping("/validacliente")
    public ResponseEntity<Boolean> validaCliente(@RequestBody Integer id){
        return ResponseEntity.ok(validaClienteUC.execute(id));
    }

    @PostMapping("/validajogo")
    public ResponseEntity<Boolean> validaJogo(@RequestBody int id){
        return ResponseEntity.ok(validaJogoUC.execute(id));
    }

    @PostMapping("/validaaluguel")
    public ResponseEntity<Boolean> validaAluguel(@RequestBody int id){
        return ResponseEntity.ok(validaAluguelUC.execute(id));
    }

    @GetMapping("cliente/aluguel/{numero}")
    public ResponseEntity<List<AluguelDTO>> listaAlugueisPorCliente(@PathVariable int numero){
        return ResponseEntity.ok(listaAlugueisByClienteUC.execute(numero));
    }

    @GetMapping("jogo/aluguel/{numero}")
    public ResponseEntity<List<AluguelDTO>> listaAlugueisPorJogo(@PathVariable int numero){
        return ResponseEntity.ok(listaAlugueisByJogoUC.execute(numero));
    }

    @GetMapping("/aluguel/valorjogo/{codigo}")
    public ResponseEntity<Double> calculaValorJogo(@PathVariable int codigo){
        try{
            return ResponseEntity.ok(calculaPrecoJogoUC.execute(codigo));
        } catch(NoSuchElementException e){
            return ResponseEntity.notFound().build();
        } catch(Exception e){
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/aluguel/valorfinal/{identificador}")
    public ResponseEntity<Double> calculaValorFinalAluguel(@PathVariable int identificador){
        try{
            return ResponseEntity.ok(calculaPrecoFinalAluguelUC.execute(identificador));
        } catch(NoSuchElementException e){
            return ResponseEntity.notFound().build();
        } catch(Exception e){
            return ResponseEntity.status(500).body(null);
        }
    }
}
