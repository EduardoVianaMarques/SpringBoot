package com.evm.school.services;
import com.evm.school.models.EstudanteModel;
import com.evm.school.repositores.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


// Indica que esta classe pertence à camada de serviço
// O Spring irá gerenciar essa classe automaticamente
@Service
public class EstudantesService {

    // Injeta automaticamente o repository dentro do service
    // Isso permite acessar o banco de dados
    @Autowired
    private EstudanteRepository estudanteRepository;
//----------------------------------------------------------------------------------------------------------------------
    // Método responsável por buscar todos os estudantes no banco
    public List<EstudanteModel> findall(){

        // O método findAll() é fornecido pelo JpaRepository
        // Ele retorna todos os registros da tabela
        return estudanteRepository.findAll();
    }
//----------------------------------------------------------------------------------------------------------------------
    // Método responsável por criar um novo estudante
    public EstudanteModel criarEstudante(EstudanteModel estudanteModel){
        // O método save() salva um objeto no banco
        // Se o objeto não tiver ID → ele cria um novo registro
        return estudanteRepository.save(estudanteModel);
    }
//----------------------------------------------------------------------------------------------------------------------
    // Método responsável por atualizar um estudante existente
    public EstudanteModel atualizarEstudante(Long id, EstudanteModel estudanteModel){
        // Busca o estudante no banco pelo ID
        // findById retorna um Optional
        EstudanteModel newEstudante = estudanteRepository.findById(id).get();
        // Atualiza os campos do estudante
        newEstudante.setNome(estudanteModel.getNome());
        newEstudante.setEmail(estudanteModel.getEmail());
        // Salva novamente no banco com os novos dados
        return estudanteRepository.save(newEstudante);
    }
//----------------------------------------------------------------------------------------------------------------------
    // Método responsável por deletar um estudante
    public void deletar(Long id){
        // Remove o registro da tabela usando o ID
        estudanteRepository.deleteById(id);
    }
}