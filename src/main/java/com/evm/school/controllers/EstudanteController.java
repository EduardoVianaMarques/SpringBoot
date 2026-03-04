package com.evm.school.controllers;

import com.evm.school.models.EstudanteModel;
import com.evm.school.services.EstudantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/alunos")

public class EstudanteController {
    @Autowired
    private EstudantesService estudanteService;

    @PostMapping
    public EstudanteModel criarEstudante(@RequestBody EstudanteModel estudanteModel){
        return estudanteService.criarEstudante(estudanteModel);
    }


    @GetMapping
    public List<EstudanteModel> listarTodosEstudante(){
        return estudanteService.listarTodosEstudante();

    }

    @GetMapping("/{id}")
    public EstudanteModel buscarPorID(@PathVariable Long id){
        return estudanteService.buscarPorID(id);
    }

    @DeleteMapping("/{id}")
    public void deletarEstudante(@PathVariable Long id){
        estudanteService.deletarEstudante(id);

    }


}
