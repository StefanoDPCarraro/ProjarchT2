package projarch.assignment.presentation.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projarch.assignment.application.dto.cliente.ClienteResponseDTO;
import projarch.assignment.application.dto.cliente.CreateClienteDTO;
import projarch.assignment.application.useCase.CadastraClienteUC;
import projarch.assignment.application.useCase.GetAllClientesUC;
import projarch.assignment.application.useCase.ValidaClienteUC;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/acmegames")
public class ClienteController {
    private GetAllClientesUC getAllClientesUC;
    private ValidaClienteUC validaClienteUC;
    private CadastraClienteUC cadastraClienteUC;

    public ClienteController(GetAllClientesUC getAllClientesUC, ValidaClienteUC validaClienteUC, CadastraClienteUC cadastraClienteUC) {
        this.getAllClientesUC = getAllClientesUC;
        this.validaClienteUC = validaClienteUC;
        this.cadastraClienteUC = cadastraClienteUC;
    }


    @GetMapping("/cadastro/listaclientes")
    public ResponseEntity<List<ClienteResponseDTO>> listaClientes() {
        return ResponseEntity.ok(getAllClientesUC.execute());
    }
    
    @PostMapping("/validacliente")
    public ResponseEntity<Boolean> validaCliente(@RequestBody Integer id){
        return ResponseEntity.ok(validaClienteUC.execute(id));
    }

    @PostMapping("/cadastro/cadcliente")
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
