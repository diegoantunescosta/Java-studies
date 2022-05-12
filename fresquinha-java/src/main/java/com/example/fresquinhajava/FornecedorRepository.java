package com.example.fresquinhajava;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "fornecedores", path = "fornecedores")
public interface FornecedorRepository extends MongoRepository<Fornecedor,String>{

    List<Fornecedor> findByNome(String nome);
    List<Fornecedor> findByNomeContaining(String nome);
    List<Fornecedor> findByOrderByNome(String nome);
    List<Fornecedor> findByTelefone(String nome);


    

}  
