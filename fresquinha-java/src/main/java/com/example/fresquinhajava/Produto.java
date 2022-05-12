package com.example.fresquinhajava;
import org.springframework.data.annotation.Id;


public class Produto {

    @Id
    private String id;

    private String categoria;

    private String nome;

    private Integer quantidade;

    // Getter e Setters

    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
      
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    
}

