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

import com.simplesesotque.simplesestoque.models.Empresa;
import com.simplesesotque.simplesestoque.repository.EmpresaRepository;

@RestController
public class EmpresaController {
  
    @Autowired
    private EmpresaRepository _EmpresaRepository;

    @CrossOrigin
    @RequestMapping(value = "/empresas", method = RequestMethod.GET)
    public List<Empresa> Get() {
        return _EmpresaRepository.findAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/empresa/{id}", method = RequestMethod.GET)
    public ResponseEntity<Empresa> GetById(@PathVariable(value = "id") long id) {
        Optional<Empresa> empresa = _EmpresaRepository.findById(id);

        if (empresa.isPresent())
            return new ResponseEntity<Empresa>(empresa.get(), HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    
    @RequestMapping(value = "/empresa", method = RequestMethod.POST)
    public Empresa Post(@RequestBody Empresa empresa) {
        return _EmpresaRepository.save(empresa);
    }

    @CrossOrigin
    @RequestMapping(value = "/empresa/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Empresa> Put(@PathVariable(value = "id") long id, @RequestBody Empresa newEmpresa)
    {
        Optional<Empresa> oldEmpresa = _EmpresaRepository.findById(id);
        if(oldEmpresa.isPresent()){
            Empresa empresa = oldEmpresa.get();
            empresa.setCnpj(newEmpresa.getCnpj());
            empresa.setNome(newEmpresa.getNome());
            empresa.setNomeFantasia(newEmpresa.getNomeFantasia());
            empresa.setBairro(newEmpresa.getBairro());
            empresa.setCep(newEmpresa.getCep());
            empresa.setCidade(newEmpresa.getCidade());
            empresa.setComplemento(newEmpresa.getComplemento());
            empresa.setEmail(newEmpresa.getEmail());
            empresa.setEstado(newEmpresa.getEstado());
            empresa.setFacebook(newEmpresa.getFacebook());
            empresa.setInstagram(newEmpresa.getInstagram());
            empresa.setNumero(newEmpresa.getNumero());
            // empresa.setResponsavel(newEmpresa.getResponsavel());
            empresa.setRua(newEmpresa.getRua());
            empresa.setTelefone(newEmpresa.getTelefone());
            empresa.setWhatsapp(newEmpresa.getWhatsapp());
            
            
            _EmpresaRepository.save(empresa);
            return new ResponseEntity<Empresa>(empresa, HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @RequestMapping(value = "/empresa/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<Empresa> empresa = _EmpresaRepository.findById(id);
        if(empresa.isPresent()){
            _EmpresaRepository.delete(empresa.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
