package com.project.projectOne.controllers;


import com.project.projectOne.entities.User;
import com.project.projectOne.services.UserService;
import com.project.projectOne.services.exceptions.DataBaseException;
import com.project.projectOne.services.exceptions.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController                     // Controller do objeto User;
@RequestMapping(value = "/user")    // Define o endpoint do objeto;

public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping                     // Define o método do endpoint;
    public ResponseEntity<List<User>> findAll(){
        List<User> userList = userService.findAll();
        return ResponseEntity.ok().body(userList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Integer id){
        User user = userService.findUserById(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public ResponseEntity<User> inserUser(@RequestBody User user){
        user = userService.inserUser(user);
        return ResponseEntity.ok().body(user);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User userData){
        try{
            userData = userService.updateUser(id, userData);
            return ResponseEntity.ok().body(userData);
        } catch(RuntimeException err){
            throw new IdNotFoundException(id);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Integer id){
        try{
            userService.deleteUser(id);
            return ResponseEntity.noContent().build();
        } catch(EmptyResultDataAccessException err){
            throw new IdNotFoundException(id);
        } catch(DataIntegrityViolationException err){
            throw new DataBaseException(err.getMessage());
        }
    }
}
