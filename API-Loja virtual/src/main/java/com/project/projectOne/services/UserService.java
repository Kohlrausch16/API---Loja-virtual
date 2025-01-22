package com.project.projectOne.services;

import com.project.projectOne.entities.User;
import com.project.projectOne.repositories.UserRepository;
import com.project.projectOne.services.exceptions.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service                            //Informa que isto é um service;

public class UserService {

    @Autowired
    UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findUserById(Integer id){
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new IdNotFoundException(id));
    }

    public User inserUser(User user){
        return repository.save(user);
    }

    public void deleteUser(Integer id){
        repository.deleteById(id);
    }
    
    public User updateUser(Integer id, User user){
        User entity = repository.getReferenceById(id);
        this.updateData(entity, user);
        return repository.save(entity);
    }

    private void updateData(User entity, User user){
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPassword(user.getPassword());
    }

}
