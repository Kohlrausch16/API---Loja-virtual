package com.project.projectOne.controllers;

import com.project.projectOne.entities.Category;
import com.project.projectOne.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/category")

public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping                                         // Define o método do endpoint;
    public ResponseEntity<List<Category>> findAll(){
        List<Category> categoryList = categoryService.findAll();
        return ResponseEntity.ok().body(categoryList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findCategoryById(@PathVariable Integer id){
        Category category = categoryService.findCategoryById(id);
        return ResponseEntity.ok().body(category);
    }
}
