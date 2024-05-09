package com.Aplicacao2024.entidades;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String id;
    public String nome;
    public String cpf;

    public User(String id, String nome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
