package com.project.projectOne.services;

import com.project.projectOne.entities.Category;
import com.project.projectOne.entities.User;
import com.project.projectOne.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository repository;

    public List<Category> findAll(){
        return repository.findAll();
    }

    public Category findCategoryById(Integer id){
        Optional<Category> category = repository.findById(id);
        return category.get();
    }

}
