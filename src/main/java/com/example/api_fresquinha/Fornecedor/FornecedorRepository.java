package com.example.api_fresquinha.Fornecedor;

import org.springframework.data.repository.CrudRepository;

public interface FornecedorRepository extends CrudRepository<Fornecedor, Integer>{

    void deleteById(Long id);

    
}
