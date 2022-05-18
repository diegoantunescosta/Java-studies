package com.example.fresquinhajava;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "vendedos", path = "vendedores")
public interface VendedorRepository extends MongoRepository<Vendedor,String>{

    List<Vendedor> findByNome(String nome);
    List<Vendedor> findByNomeContaining(String nome);
}
