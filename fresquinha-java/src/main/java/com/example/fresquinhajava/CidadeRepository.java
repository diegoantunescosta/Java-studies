package com.example.fresquinhajava;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "cidades", path = "cidades")
public interface CidadeRepository extends MongoRepository<Estados,String>{

    List<Cidade> findByNome(String nome);
    List<Cidade> findByNomeContaining(String nome);

}  