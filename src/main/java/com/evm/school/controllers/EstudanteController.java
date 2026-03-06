package com.evm.school.controllers;

import com.evm.school.models.EstudanteModel;
import com.evm.school.services.EstudantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/Estudantes")

public class EstudanteController {
    @Autowired
    private EstudantesService estudanteService;

    @GetMapping
    public List<EstudanteModel> listarTodosEstudante(){
        return estudanteService. findall();

    }

    @PostMapping
    public EstudanteModel criarEstudante(@RequestBody EstudanteModel estudanteModel){
        return estudanteService.criarEstudante(estudanteModel);
    }


    @PutMapping("/{id}")
    public EstudanteModel atualizarEstudante(@PathVariable Long id,@RequestBody EstudanteModel estudanteModel){
        return  estudanteService.atualizarEstudante(id, estudanteModel);
    }

    @DeleteMapping("/{id}")
    public void deletarEstudante(@PathVariable Long id){
        estudanteService.deletarEstudante(id);

    }


}
