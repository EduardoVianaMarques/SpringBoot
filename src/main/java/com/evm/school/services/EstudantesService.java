package com.evm.school.services;


import com.evm.school.models.EstudanteModel;
import com.evm.school.repositores.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<EstudanteModel> buscarPorID(Long id){
        return  estudanteRepository.findById(id);

    }

    public EstudanteModel atualizarEstudante(Long id, EstudanteModel estudanteModel){
        EstudanteModel newEstudante = estudanteRepository.findById(id).get();
        newEstudante.setNome(estudanteModel.getNome());
        return  estudanteRepository.save(newEstudante);
    }

    public void deletarEstudante(Long id){
        estudanteRepository.deleteById(id);

    }


}