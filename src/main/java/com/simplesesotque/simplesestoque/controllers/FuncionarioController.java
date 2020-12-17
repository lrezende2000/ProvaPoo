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

import com.simplesesotque.simplesestoque.models.Funcionario;
import com.simplesesotque.simplesestoque.repository.FuncionarioRepository;

@RestController
public class FuncionarioController {
    @Autowired
    private FuncionarioRepository _FuncionarioRepository;

    @CrossOrigin
    @RequestMapping(value = "/funcionarios", method = RequestMethod.GET)
    public List<Funcionario> Get() {
        return _FuncionarioRepository.findAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/funcionario/{id}", method = RequestMethod.GET)
    public ResponseEntity<Funcionario> GetById(@PathVariable(value = "id") long id) {
        Optional<Funcionario> funcionario = _FuncionarioRepository.findById(id);

        if (funcionario.isPresent())
            return new ResponseEntity<Funcionario>(funcionario.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @RequestMapping(value = "/funcionario", method = RequestMethod.POST)
    public Funcionario Post(@RequestBody Funcionario funcionario) {
        return _FuncionarioRepository.save(funcionario);
    }

    @CrossOrigin
    @RequestMapping(value = "/funcionario/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Funcionario> Put(@PathVariable(value = "id") long id, @RequestBody Funcionario newFuncionario) {
        Optional<Funcionario> oldFuncionario = _FuncionarioRepository.findById(id);
        if (oldFuncionario.isPresent()) {
            Funcionario funcionario = oldFuncionario.get();
            funcionario.setCargo(newFuncionario.getCargo());
            funcionario.setCarteriaTrabalho(newFuncionario.getCarteriaTrabalho());
            funcionario.setDataAdmissao(newFuncionario.getDataAdmissao());
            funcionario.setDataDemissao(newFuncionario.getDataDemissao());
            funcionario.setEmpresa(newFuncionario.getEmpresa());
            funcionario.setPessoa(newFuncionario.getPessoa());
            funcionario.setSalarioBase(newFuncionario.getSalarioBase());
            funcionario.setSituacao(newFuncionario.getSituacao());
            _FuncionarioRepository.save(funcionario);
            return new ResponseEntity<Funcionario>(funcionario, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @RequestMapping(value = "/funcionario/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id) {
        Optional<Funcionario> funcionario = _FuncionarioRepository.findById(id);
        if (funcionario.isPresent()) {
            _FuncionarioRepository.delete(funcionario.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
