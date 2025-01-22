package com.project.projectOne.services;

import com.project.projectOne.entities.Product;
import com.project.projectOne.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public List<Product> findAll(){
        return repository.findAll();
    }

    public Product findProductById(Integer id){
        Optional<Product> product = repository.findById(id);
        return product.get();
    }

}
