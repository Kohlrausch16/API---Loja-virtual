package com.project.projectOne.controllers;

import com.project.projectOne.entities.Order;
import com.project.projectOne.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/order")

public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping                                         // Define o método do endpoint;
    public ResponseEntity<List<Order>> findAll(){
        List<Order> orderList = orderService.findAll();
        return ResponseEntity.ok().body(orderList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findOrderById(@PathVariable Integer id){
        Order order = orderService.findOrderById(id);
        return ResponseEntity.ok().body(order);
    }
}
