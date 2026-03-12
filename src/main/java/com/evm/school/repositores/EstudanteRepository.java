package com.evm.school.repositores;
import com.evm.school.models.EstudanteModel;
import org.springframework.data.jpa.repository.JpaRepository;

// Define uma interface chamada EstudanteRepository
// Ela estende JpaRepository para herdar métodos de acesso ao banco
public interface EstudanteRepository extends JpaRepository<EstudanteModel, Long> {
}