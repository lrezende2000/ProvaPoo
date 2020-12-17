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

import com.simplesesotque.simplesestoque.models.VendaItem;
import com.simplesesotque.simplesestoque.repository.VendaItemRepository;

@RestController
public class VendaItemController {
    @Autowired
    private VendaItemRepository _VendaItemRepository;

    @CrossOrigin
    @RequestMapping(value = "/itens", method = RequestMethod.GET)
    public List<VendaItem> Get() {
        return _VendaItemRepository.findAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<VendaItem> GetById(@PathVariable(value = "id") long id) {
        Optional<VendaItem> vendaItem = _VendaItemRepository.findById(id);

        if (vendaItem.isPresent())
            return new ResponseEntity<VendaItem>(vendaItem.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @RequestMapping(value = "/item", method = RequestMethod.POST)
    public VendaItem Post(@RequestBody VendaItem vendaItem) {
        return _VendaItemRepository.save(vendaItem);
    }

    @CrossOrigin
    @RequestMapping(value = "/item/{id}", method = RequestMethod.PUT)
    public ResponseEntity<VendaItem> Put(@PathVariable(value = "id") long id, @RequestBody VendaItem newVendaItem) {
        Optional<VendaItem> oldVendaItem = _VendaItemRepository.findById(id);
        if (oldVendaItem.isPresent()) {
            VendaItem vendaItem = oldVendaItem.get();
            vendaItem.setCancelado(newVendaItem.getCancelado());
            vendaItem.setDesconto(newVendaItem.getDesconto());
            vendaItem.setLocal(newVendaItem.getLocal());
            vendaItem.setProduto(newVendaItem.getProduto());
            vendaItem.setQuantidade(newVendaItem.getQuantidade());
            vendaItem.setValorUnitario(newVendaItem.getValorUnitario());
            vendaItem.setVenda(newVendaItem.getVenda());
            _VendaItemRepository.save(vendaItem);
            return new ResponseEntity<VendaItem>(vendaItem, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @RequestMapping(value = "/item/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id) {
        Optional<VendaItem> vendaItem = _VendaItemRepository.findById(id);
        if (vendaItem.isPresent()) {
            _VendaItemRepository.delete(vendaItem.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
