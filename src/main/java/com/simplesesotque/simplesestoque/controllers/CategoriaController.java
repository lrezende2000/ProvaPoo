package com.simplesesotque.simplesestoque.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.simplesesotque.simplesestoque.models.Categoria;
import com.simplesesotque.simplesestoque.repository.CategoriaRepository;

@RestController
public class CategoriaController {
    @Autowired
    private CategoriaRepository _CategoriaRepository;

    @CrossOrigin
    @RequestMapping(value = "/categorias", method = RequestMethod.GET)
    public List<Categoria> Get() {
        return _CategoriaRepository.findAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/categoria/{id}", method = RequestMethod.GET)
    public ResponseEntity<Categoria> GetById(@PathVariable(value = "id") long id) {
        Optional<Categoria> categoria = _CategoriaRepository.findById(id);

        if (categoria.isPresent())
            return new ResponseEntity<Categoria>(categoria.get(), HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @RequestMapping(value = "/categoria", method = RequestMethod.POST)
    public Categoria Post(@RequestBody Categoria categoria) {
        return _CategoriaRepository.save(categoria);
    }

    @CrossOrigin
    @RequestMapping(value = "/categoria/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Categoria> Put(@PathVariable(value = "id") long id, @RequestBody Categoria newCategoria)
    {
        Optional<Categoria> oldCategoria = _CategoriaRepository.findById(id);
        if(oldCategoria.isPresent()){
            Categoria categoria = oldCategoria.get();
            categoria.setNome(newCategoria.getNome());
            categoria.setMarca(newCategoria.getMarca());
            
            _CategoriaRepository.save(categoria);
            return new ResponseEntity<Categoria>(categoria, HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @RequestMapping(value = "/categoria/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<Categoria> categoria = _CategoriaRepository.findById(id);
        if(categoria.isPresent()){
            _CategoriaRepository.delete(categoria.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  
}
