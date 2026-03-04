package com.evm.school.models;


import jakarta.persistence.*;

@Entity
@Table(name = "tb_aluno")
public class EstudanteModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long id;

    @Column(name = "Nome_Aluno")
    private String nome;
    @Column(name = "Email_Alunos")
    private String email;
    private int idade;

    public EstudanteModel() {
    }

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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}