package projarch.assignment.adapters.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projarch.assignment.application.dto.request.CreateClienteDTO;
import projarch.assignment.application.dto.response.AluguelDTO;
import projarch.assignment.application.dto.response.ClienteResponseDTO;
import projarch.assignment.application.dto.response.JogoDTO;
import projarch.assignment.application.useCase.CadastraJogoUC;
import projarch.assignment.application.useCase.GetAllAlugueisUC;
import projarch.assignment.application.useCase.GetAllJogosUC;
import projarch.assignment.application.useCase.ValidaAluguelUC;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import projarch.assignment.application.useCase.CadastraClienteUC;
import projarch.assignment.application.useCase.GetAllClientesUC;


@RestController
@RequestMapping("/acmegames/cadastro")
public class CadastroController {
    private final GetAllAlugueisUC getAllAlugueisUC;
    private final ValidaAluguelUC validaAluguelUC;
    private final GetAllJogosUC getAllJogosUC;
    private final CadastraJogoUC cadastraJogoUC;
    private final GetAllClientesUC getAllClientesUC;
    
    private final CadastraClienteUC cadastraClienteUC;

    public CadastroController(GetAllAlugueisUC getAllAlugueisUC, ValidaAluguelUC validaAluguelUC, GetAllJogosUC getAllJogosUC, CadastraJogoUC cadastraJogoUC, GetAllClientesUC getAllClientesUC, CadastraClienteUC cadastraClienteUC) {
        this.getAllAlugueisUC = getAllAlugueisUC;
        this.validaAluguelUC = validaAluguelUC;
        this.getAllJogosUC = getAllJogosUC;
        this.cadastraJogoUC = cadastraJogoUC;
        this.getAllClientesUC = getAllClientesUC;
        this.cadastraClienteUC = cadastraClienteUC;
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

    @PostMapping("/cadjogo")
    public boolean cadastraJogo(@RequestBody JogoDTO jogoDTO) {
        return cadastraJogoUC.execute(jogoDTO);
    }
    
    @GetMapping("/listaclientes")
    public ResponseEntity<List<ClienteResponseDTO>> listaClientes() {
        return ResponseEntity.ok(getAllClientesUC.execute());
    }

    @PostMapping("/cadcliente")
    public ResponseEntity<Boolean> cadastraCliente(@RequestBody CreateClienteDTO dto) {        
        try {
            if (cadastraClienteUC.execute(dto)) {
                return ResponseEntity.ok(true);
            } else {
                return ResponseEntity.badRequest().body(false);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erro de validação: " + e.getMessage());
            return ResponseEntity.badRequest().body(false);
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar cliente: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(500).body(false);
        }
    }
}
