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

import com.simplesesotque.simplesestoque.models.Venda;
import com.simplesesotque.simplesestoque.repository.VendaRepository;

@RestController
public class VendaController {
    @Autowired
    private VendaRepository _VendaRepository;

    @CrossOrigin
    @RequestMapping(value = "/vendas", method = RequestMethod.GET)
    public List<Venda> Get() {
        return _VendaRepository.findAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/venda/{id}", method = RequestMethod.GET)
    public ResponseEntity<Venda> GetById(@PathVariable(value = "id") long id) {
        Optional<Venda> venda = _VendaRepository.findById(id);

        if (venda.isPresent())
            return new ResponseEntity<Venda>(venda.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @RequestMapping(value = "/venda", method = RequestMethod.POST)
    public Venda Post(@RequestBody Venda venda) {
        return _VendaRepository.save(venda);
    }

    @CrossOrigin
    @RequestMapping(value = "/venda/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Venda> Put(@PathVariable(value = "id") long id, @RequestBody Venda newVenda) {
        Optional<Venda> oldVenda = _VendaRepository.findById(id);
        if (oldVenda.isPresent()) {
            Venda venda = oldVenda.get();
            venda.setCliente(newVenda.getCliente());
            venda.setDataValidadeCartao(newVenda.getDataValidadeCartao());
            venda.setDataVenda(newVenda.getDataVenda());
            venda.setDesconto(newVenda.getDesconto());
            venda.setEntrega(newVenda.getEntrega());
            venda.setEntregador(newVenda.getEntregador());
            venda.setFormaPagemento(newVenda.getFormaPagemento());
            venda.setFuncionario(newVenda.getFuncionario());
            venda.setHoraVenda(newVenda.getHoraVenda());
            venda.setNumeroBoleto(newVenda.getNumeroBoleto());
            venda.setNumeroCartao(newVenda.getNumeroCartao());
            venda.setNumeroParcelas(newVenda.getNumeroParcelas());
            venda.setPlacaVeiculo(newVenda.getPlacaVeiculo());
            venda.setValorFrete(newVenda.getValorFrete());
            venda.setValorTotal(newVenda.getValorTotal());
            venda.setVendaOrigem(newVenda.getVendaOrigem());
            venda.setVendaStatus(newVenda.getVendaStatus());
            _VendaRepository.save(venda);
            return new ResponseEntity<Venda>(venda, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @RequestMapping(value = "/venda/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id) {
        Optional<Venda> venda = _VendaRepository.findById(id);
        if (venda.isPresent()) {
            _VendaRepository.delete(venda.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
