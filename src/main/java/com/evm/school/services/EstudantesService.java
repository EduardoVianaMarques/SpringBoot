package com.evm.school.services;


import com.evm.school.models.EstudanteModel;
import com.evm.school.repositores.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudantesService {

    @Autowired
    private EstudanteRepository estudanteRepository;

    public EstudanteModel criarEstudante(EstudanteModel estudanteModel){
        return estudanteRepository.save(estudanteModel);
    }

    public List<EstudanteModel> listarTodosEstudante(){
        return estudanteRepository.findAll();

    }
    public EstudanteModel buscarPorID(Long id){
        return  estudanteRepository.findById(id).orElse(null);

    }

    public void deletarEstudante(Long id){
        estudanteRepository.deleteById(id);

    }


}