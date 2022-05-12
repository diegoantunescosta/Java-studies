package com.example.fresquinhajava;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "produtos", path = "produtos")
public interface ProdutoRepository extends MongoRepository<Produto,String>{

    List<Produto> findByNome(String nome);
    List<Produto> findByNomeContaining(String nome);

    @Query ("{'categoria.id' : ?0}")
    List<Produto> findByCategoriaid(String id);

    @Query ("{'fornecedor.id' : ?0}")
    List<Produto> findByFornecedorid(String id);

}  