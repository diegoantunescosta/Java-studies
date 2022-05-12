package com.example.fresquinhajava;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "estados", path = "estados")
public interface EstadoRepository extends MongoRepository<Estados,String>{

    List<Estados> findByNome(String nome);
    List<Estados> findByNomeContaining(String nome);

}  