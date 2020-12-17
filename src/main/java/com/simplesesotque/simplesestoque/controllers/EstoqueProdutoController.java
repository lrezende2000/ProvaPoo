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

import com.simplesesotque.simplesestoque.models.EstoqueProduto;
import com.simplesesotque.simplesestoque.repository.EstoqueProdutoRepository;

@RestController
public class EstoqueProdutoController {
    @Autowired
    private EstoqueProdutoRepository _EstoqueProdutoRepository;

    @CrossOrigin
    @RequestMapping(value = "/produtos", method = RequestMethod.GET)
    public List<EstoqueProduto> Get() {
        return _EstoqueProdutoRepository.findAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/produto/{id}", method = RequestMethod.GET)
    public ResponseEntity<EstoqueProduto> GetById(@PathVariable(value = "id") long id) {
        Optional<EstoqueProduto> produto = _EstoqueProdutoRepository.findById(id);

        if (produto.isPresent())
            return new ResponseEntity<EstoqueProduto>(produto.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @RequestMapping(value = "/produto", method = RequestMethod.POST)
    public EstoqueProduto Post(@RequestBody EstoqueProduto produto) {
        return _EstoqueProdutoRepository.save(produto);
    }

    @CrossOrigin
    @RequestMapping(value = "/produto/{id}", method = RequestMethod.PUT)
    public ResponseEntity<EstoqueProduto> Put(@PathVariable(value = "id") long id, @RequestBody EstoqueProduto newProduto) {
        Optional<EstoqueProduto> oldProduto = _EstoqueProdutoRepository.findById(id);
        if (oldProduto.isPresent()) {
            EstoqueProduto produto = oldProduto.get();
            produto.setCategoria(newProduto.getCategoria());
            produto.setDescricao(newProduto.getDescricao());
            produto.setEstoqueLocal(newProduto.getEstoqueLocal());
            produto.setFornecedor(newProduto.getFornecedor());
            produto.setNome(newProduto.getNome());
            produto.setQuantidadeAtual(newProduto.getQuantidadeAtual());
            produto.setQuantidadeIdeal(newProduto.getQuantidadeIdeal());
            produto.setQuantidadeMaxima(newProduto.getQuantidadeMaxima());
            produto.setQuantidadeMinima(newProduto.getQuantidadeMinima());
            _EstoqueProdutoRepository.save(produto);
            return new ResponseEntity<EstoqueProduto>(produto, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @RequestMapping(value = "/produto/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id) {
        Optional<EstoqueProduto> produto = _EstoqueProdutoRepository.findById(id);
        if (produto.isPresent()) {
            _EstoqueProdutoRepository.delete(produto.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
