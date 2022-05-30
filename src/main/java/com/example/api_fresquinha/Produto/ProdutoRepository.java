package com.example.api_fresquinha.Produto;


import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto, Integer>{

    void deleteById(Long id);

    
}
