package com.example.fresquinha_mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@CrossOrigin(maxAge = 3600)
@Controller
// Indetifica que a classe é um controlador REST. 
@RequestMapping(path = "/categorias") //Especifica o nome do recurso REST
public class CategoriaController {

    // Instância do repositório para usarmos os métodos CRUD
    @Autowired
    private CategoriaRepository categoriaRepository;

    // GET: Retorna todas asa categorias
    @GetMapping
    public @ResponseBody Iterable<Categoria> consultarCategorias() {
        return categoriaRepository.findAll();
    }


    //POST: Incluir uma categoria
    @PostMapping
    public @ResponseBody Categoria incluirCategoria(@RequestBody Categoria categoria) {
        Categoria novaCategoria = new Categoria();
        novaCategoria.setNome(categoria.getNome());
        return categoriaRepository.save(novaCategoria);
    } 

}
