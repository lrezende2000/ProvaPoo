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

import com.simplesesotque.simplesestoque.models.Fornecedor;
import com.simplesesotque.simplesestoque.repository.FornecedorRepository;

@RestController
public class FornecedorController {
    @Autowired
    private FornecedorRepository _FornecedorRepository;

    @CrossOrigin
    @RequestMapping(value = "/fornecedores", method = RequestMethod.GET)
    public List<Fornecedor> Get() {
        return _FornecedorRepository.findAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/fornecedor/{id}", method = RequestMethod.GET)
    public ResponseEntity<Fornecedor> GetById(@PathVariable(value = "id") long id) {
        Optional<Fornecedor> fornecedor = _FornecedorRepository.findById(id);

        if (fornecedor.isPresent())
            return new ResponseEntity<Fornecedor>(fornecedor.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @RequestMapping(value = "/fornecedor", method = RequestMethod.POST)
    public Fornecedor Post(@RequestBody Fornecedor fornecedor) {
        return _FornecedorRepository.save(fornecedor);
    }

    @CrossOrigin
    @RequestMapping(value = "/fornecedor/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Fornecedor> Put(@PathVariable(value = "id") long id, @RequestBody Fornecedor newFornecedor) {
        Optional<Fornecedor> oldFornecedor = _FornecedorRepository.findById(id);
        if (oldFornecedor.isPresent()) {
            Fornecedor fornecedor = oldFornecedor.get();
            fornecedor.setBairro(newFornecedor.getBairro());
            fornecedor.setCep(newFornecedor.getCep());
            fornecedor.setCidade(newFornecedor.getCidade());
            fornecedor.setComplemento(newFornecedor.getComplemento());
            fornecedor.setCpfCnpj(newFornecedor.getCpfCnpj());
            fornecedor.setEmail(newFornecedor.getEmail());
            fornecedor.setEstado(newFornecedor.getEstado());
            fornecedor.setNome(newFornecedor.getNome());
            fornecedor.setNumero(newFornecedor.getNumero());
            fornecedor.setRua(newFornecedor.getRua());
            fornecedor.setTelefone(newFornecedor.getTelefone());
            _FornecedorRepository.save(fornecedor);
            return new ResponseEntity<Fornecedor>(fornecedor, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @RequestMapping(value = "/fornecedor/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id) {
        Optional<Fornecedor> fornecedor = _FornecedorRepository.findById(id);
        if (fornecedor.isPresent()) {
            _FornecedorRepository.delete(fornecedor.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
