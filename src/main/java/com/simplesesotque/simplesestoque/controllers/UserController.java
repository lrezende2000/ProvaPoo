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

import com.simplesesotque.simplesestoque.models.User;
import com.simplesesotque.simplesestoque.repository.UserRepository;

@RestController
public class UserController {
    @Autowired
    private UserRepository _UserRepository;

    @CrossOrigin
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> Get() {
        return _UserRepository.findAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> GetById(@PathVariable(value = "id") long id) {
        Optional<User> user = _UserRepository.findById(id);

        if (user.isPresent())
            return new ResponseEntity<User>(user.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User Post(@RequestBody User user) {
        return _UserRepository.save(user);
    }

    @CrossOrigin
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> Put(@PathVariable(value = "id") long id, @RequestBody User newUser) {
        Optional<User> oldUser = _UserRepository.findById(id);
        if (oldUser.isPresent()) {
            User user = oldUser.get();
            user.setEmail(newUser.getEmail());
            user.setSenha(newUser.getSenha());
            user.setUsername(newUser.getUsername());
            user.setEmpresaId(newUser.getEmpresaId());
            _UserRepository.save(user);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id) {
        Optional<User> user = _UserRepository.findById(id);
        if (user.isPresent()) {
            _UserRepository.delete(user.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}