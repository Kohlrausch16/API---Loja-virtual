package com.project.projectOne.services;

import com.project.projectOne.entities.Order;
import com.project.projectOne.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository repository;

    public List<Order> findAll(){
        return repository.findAll();
    }

    public Order findOrderById(Integer id){
        Optional<Order> order = repository.findById(id);
        return order.get();
    }

}
