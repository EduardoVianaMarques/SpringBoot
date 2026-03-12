package com.evm.school.controllers;
import com.evm.school.models.EstudanteModel;
import com.evm.school.services.EstudantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;


// Indica que esta classe é um controller REST
// Ou seja, ela responde requisições HTTP (GET, POST, PUT, DELETE)
@RestController

// Define o caminho base da API
// Todas as requisições começarão com /Estudantes
@RequestMapping(path = "/Estudantes")
public class EstudanteController {

    // Injeta automaticamente o service dentro do controller
    @Autowired
    private EstudantesService estudanteService;

//----------------------------------------------------------------------------------------------------------------------
    // Mapeia requisições HTTP do tipo GET
    // Endpoint: GET /Estudantes
    @GetMapping
    public ResponseEntity<List<EstudanteModel>> findAll(){

        // Chama o service para buscar todos os estudantes
        List<EstudanteModel> requeste = estudanteService.findall();

        // Retorna resposta HTTP 200 (OK) com a lista de estudantes
        return ResponseEntity.ok().body(requeste);
    }
//----------------------------------------------------------------------------------------------------------------------
    // Mapeia requisições HTTP POST
    // Endpoint: POST /Estudantes
    @PostMapping
    public ResponseEntity<EstudanteModel> criarEstudante(@RequestBody EstudanteModel estudanteModel){
        // Chama o service para salvar o estudante no banco
        EstudanteModel requeste = estudanteService.criarEstudante(estudanteModel);
        // Cria a URI do recurso criado
        // Exemplo: /Estudantes/1
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(requeste.getId())
                .toUri();
        // Retorna status HTTP 201 (Created)
        // e a URI do novo recurso criado
        return ResponseEntity.created(uri).body(requeste);
    }
//----------------------------------------------------------------------------------------------------------------------
    // Mapeia requisições HTTP DELETE
    // Endpoint: DELETE /Estudantes/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar (@PathVariable Long id){
        // Chama o service para deletar o estudante
        estudanteService.deletar(id);
        // Retorna resposta HTTP 204 (No Content)
        return ResponseEntity.noContent().build();
    }
//----------------------------------------------------------------------------------------------------------------------
    // Mapeia requisições HTTP PUT
    // Endpoint: PUT /Estudantes/{id}
    @PutMapping("/{id}")
    public ResponseEntity<EstudanteModel> atualizarEstudante(@PathVariable Long id, @RequestBody EstudanteModel estudanteModel){
        // Chama o service para atualizar os dados do estudante
        EstudanteModel model = estudanteService.atualizarEstudante(id, estudanteModel);
        // Retorna HTTP 200 com o objeto atualizado
        return ResponseEntity.ok().body(model);
    }
}