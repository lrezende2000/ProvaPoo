package com.simplesesotque.simplesestoque.controllers;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.simplesesotque.simplesestoque.models.EstoqueLocal;
import com.simplesesotque.simplesestoque.repository.EstoqueLocalRepository;

@CrossOrigin
@RestController
public class EstoqueLocalController {
    @Autowired
    private EstoqueLocalRepository _EstoqueLocalRepository;

    @RequestMapping(value = "/locais", method = RequestMethod.GET)
    public List<EstoqueLocal> Get() {
        return _EstoqueLocalRepository.findAll();
    }

    @RequestMapping(value = "/local/{id}", method = RequestMethod.GET)
    public ResponseEntity<EstoqueLocal> GetById(@PathVariable(value = "id") long id) {
        Optional<EstoqueLocal> local = _EstoqueLocalRepository.findById(id);

        if (local.isPresent())
            return new ResponseEntity<EstoqueLocal>(local.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/local/empresa/{empresa}", method = RequestMethod.GET)
    public ArrayList<EstoqueLocal> GetByEnterpriseLocalId(@PathVariable("empresa") Integer empresa) {
        List<EstoqueLocal> locais = _EstoqueLocalRepository.findAll();
        ArrayList<EstoqueLocal> filteredLocals = new ArrayList<>();
        
        for (int i = 0; i < locais.size(); i++) {
            if (locais.get(i).getEmpresa() == empresa) {
                filteredLocals.add(locais.get(i));
            }
        }
        return filteredLocals;
    }

    @RequestMapping(value = "/local", method = RequestMethod.POST)
    public EstoqueLocal Post(@RequestBody EstoqueLocal local) {
        return _EstoqueLocalRepository.save(local);
    }

    @RequestMapping(value = "/local/{id}", method = RequestMethod.PUT)
    public ResponseEntity<EstoqueLocal> Put(@PathVariable(value = "id") long id, @RequestBody EstoqueLocal newLocal) {
        Optional<EstoqueLocal> oldLocal = _EstoqueLocalRepository.findById(id);
        if (oldLocal.isPresent()) {
            EstoqueLocal local = oldLocal.get();
            local.setBairro(newLocal.getBairro());
            local.setCapacidadeMaxima(newLocal.getCapacidadeMaxima());
            local.setCep(newLocal.getCep());
            local.setCidade(newLocal.getCidade());
            local.setComplemento(newLocal.getComplemento());
            local.setEmpresa(newLocal.getEmpresa());
            local.setEstado(newLocal.getEstado());
            local.setNome(newLocal.getNome());
            local.setNumero(newLocal.getNumero());
            local.setRua(newLocal.getRua());
            _EstoqueLocalRepository.save(local);
            return new ResponseEntity<EstoqueLocal>(local, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/local/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id) {
        Optional<EstoqueLocal> local = _EstoqueLocalRepository.findById(id);
        if (local.isPresent()) {
            _EstoqueLocalRepository.delete(local.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
