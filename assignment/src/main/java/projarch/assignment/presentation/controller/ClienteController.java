package projarch.assignment.presentation.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projarch.assignment.application.dto.cliente.ClienteResponseDTO;
import projarch.assignment.application.useCase.GetAllClientesUC;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/acmegames/cadastro")
public class ClienteController {
    private GetAllClientesUC getAllClientesUC;

    public ClienteController(GetAllClientesUC getAllClientesUC) {
        this.getAllClientesUC = getAllClientesUC;
    }


    @GetMapping("/listaclientes")
    public ResponseEntity<List<ClienteResponseDTO>> listaClientes() {
        return ResponseEntity.ok(getAllClientesUC.execute());
    }
    
}
