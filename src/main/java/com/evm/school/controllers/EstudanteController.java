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

@RestController
@RequestMapping(path = "/Estudantes")

public class EstudanteController {
    @Autowired
    private EstudantesService estudanteService;

    @GetMapping
    public ResponseEntity<List<EstudanteModel> > findAll(){
        List<EstudanteModel> requeste = estudanteService.findall();
        return ResponseEntity.ok().body(requeste);
    }

    @PostMapping
    public ResponseEntity <EstudanteModel> criarEstudante(@RequestBody EstudanteModel estudanteModel){
        EstudanteModel requeste = estudanteService.criarEstudante(estudanteModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(estudanteModel.getId())
                .toUri();
        return  ResponseEntity.created(uri).body(requeste);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar (@PathVariable Long id){
        estudanteService.deletar(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity <EstudanteModel> atualizarEstudante(@PathVariable Long id,@RequestBody EstudanteModel estudanteModel){
        EstudanteModel model = estudanteService.atualizarEstudante(id, estudanteModel);
        return ResponseEntity.ok().body(model);
    }


}
