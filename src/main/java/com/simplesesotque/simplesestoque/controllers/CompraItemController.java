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

import com.simplesesotque.simplesestoque.models.CompraItem;
import com.simplesesotque.simplesestoque.repository.CompraItemRepository;

@RestController
public class CompraItemController {
    @Autowired
    private CompraItemRepository _CompraItemRepository;

    @CrossOrigin
    @RequestMapping(value = "/compra-itens", method = RequestMethod.GET)
    public List<CompraItem> Get() {
        return _CompraItemRepository.findAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/compra-item/{id}", method = RequestMethod.GET)
    public ResponseEntity<CompraItem> GetById(@PathVariable(value = "id") long id) {
        Optional<CompraItem> compraItem = _CompraItemRepository.findById(id);

        if (compraItem.isPresent())
            return new ResponseEntity<CompraItem>(compraItem.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @RequestMapping(value = "/compra-item", method = RequestMethod.POST)
    public CompraItem Post(@RequestBody CompraItem compraItem) {
        return _CompraItemRepository.save(compraItem);
    }

    @CrossOrigin
    @RequestMapping(value = "/compra-item/{id}", method = RequestMethod.PUT)
    public ResponseEntity<CompraItem> Put(@PathVariable(value = "id") long id, @RequestBody CompraItem newCompraItem) {
        Optional<CompraItem> oldCompraItem = _CompraItemRepository.findById(id);
        if (oldCompraItem.isPresent()) {
            CompraItem compraItem = oldCompraItem.get();
            compraItem.setCancelado(newCompraItem.getCancelado());
            compraItem.setLocal(newCompraItem.getLocal());
            compraItem.setProduto(newCompraItem.getProduto());
            compraItem.setQuantidade(newCompraItem.getQuantidade());
            compraItem.setValorUnitario(newCompraItem.getValorUnitario());
            compraItem.setVenda(newCompraItem.getVenda());
            _CompraItemRepository.save(compraItem);
            return new ResponseEntity<CompraItem>(compraItem, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @RequestMapping(value = "/compra-item/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id) {
        Optional<CompraItem> compraItem = _CompraItemRepository.findById(id);
        if (compraItem.isPresent()) {
            _CompraItemRepository.delete(compraItem.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  
}
