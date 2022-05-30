package com.example.api_fresquinha.Vendedor;


import org.springframework.data.repository.CrudRepository;

public interface VendedorRepository extends CrudRepository<Vendedor, Integer>{

    void deleteById(Long id);

    
}
