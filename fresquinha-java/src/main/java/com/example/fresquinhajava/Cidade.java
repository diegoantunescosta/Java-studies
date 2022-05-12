package com.example.fresquinhajava;

import org.springframework.data.annotation.Id;

public class Cidade {
    
    @Id
    private String nome;

    // Getter e Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
