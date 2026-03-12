package com.evm.school.models;
import com.evm.school.Enum.EstudanteEnum;
import jakarta.persistence.*;


// Indica que esta classe é uma entidade JPA (tabela no banco)
@Entity

@Table(name = "tb_aluno")
public class EstudanteModel {

    // Define a chave primária da tabela
    @Id
    // Define que o ID será gerado automaticamente pelo banco
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Coluna que armazena o nome do estudante
    @Column(name = "Nome_Aluno")
    private String nome;
    // Coluna que armazena o email do estudante
    @Column(name = "Email_Alunos")
    private String email;
    // Campo que armazena o status do estudante utilizando ENUM
    // EnumType.STRING salva o nome do enum no banco
    @Enumerated(EnumType.STRING)
    @Column(name = "Status_Aluno")
    private EstudanteEnum status;
//----------------------------------------------------------------------------------------------------------------------
    // Construtor vazio obrigatório para o JPA
    public EstudanteModel() {
    }
//----------------------------------------------------------------------------------------------------------------------

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
//----------------------------------------------------------------------------------------------------------------------

    // GET e SET do status (Enum)
    public EstudanteEnum getStatus() {
        return status;
    }
    public void setStatus(EstudanteEnum status) {
        this.status = status;
    }

}