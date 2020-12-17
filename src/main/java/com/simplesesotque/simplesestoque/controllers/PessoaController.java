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

import com.simplesesotque.simplesestoque.models.Pessoa;
import com.simplesesotque.simplesestoque.repository.PessoaRepository;

@RestController
public class PessoaController {
    @Autowired
    private PessoaRepository _PessoaRepository;

    @CrossOrigin
    @RequestMapping(value = "/pessoas", method = RequestMethod.GET)
    public List<Pessoa> Get() {
        return _PessoaRepository.findAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/pessoa/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pessoa> GetById(@PathVariable(value = "id") long id) {
        Optional<Pessoa> pessoa = _PessoaRepository.findById(id);

        if (pessoa.isPresent())
            return new ResponseEntity<Pessoa>(pessoa.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @RequestMapping(value = "/pessoa", method = RequestMethod.POST)
    public Pessoa Post(@RequestBody Pessoa pessoa) {
        return _PessoaRepository.save(pessoa);
    }

    @CrossOrigin
    @RequestMapping(value = "/pessoa/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Pessoa> Put(@PathVariable(value = "id") long id, @RequestBody Pessoa newPessoa) {
        Optional<Pessoa> oldPessoa = _PessoaRepository.findById(id);
        if (oldPessoa.isPresent()) {
            Pessoa pessoa = oldPessoa.get();
            pessoa.setEmail(newPessoa.getEmail());
            pessoa.setBairro(newPessoa.getBairro());
            pessoa.setCep(newPessoa.getCep());
            pessoa.setCidade(newPessoa.getCidade());
            pessoa.setComplemento(newPessoa.getComplemento());
            pessoa.setCpf(newPessoa.getCpf());
            pessoa.setDataNascimento(newPessoa.getDataNascimento());
            pessoa.setEstado(newPessoa.getEstado());
            pessoa.setEstadoCivil(newPessoa.getEstadoCivil());
            pessoa.setFacebook(newPessoa.getFacebook());
            pessoa.setInstagram(newPessoa.getInstagram());
            pessoa.setNome(newPessoa.getNome());
            pessoa.setNumero(newPessoa.getNumero());
            pessoa.setRua(newPessoa.getRua());
            pessoa.setSexo(newPessoa.getSexo());
            pessoa.setTelefone(newPessoa.getTelefone());
            pessoa.setWhatsapp(newPessoa.getWhatsapp());
            _PessoaRepository.save(pessoa);
            return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @RequestMapping(value = "/pessoa/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id) {
        Optional<Pessoa> pessoa = _PessoaRepository.findById(id);
        if (pessoa.isPresent()) {
            _PessoaRepository.delete(pessoa.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
