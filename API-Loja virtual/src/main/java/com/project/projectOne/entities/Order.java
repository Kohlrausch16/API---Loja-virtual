package com.project.projectOne.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.projectOne.entities.enums.OrderStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Instant moment;

    private Integer orderStatus;

    @ManyToOne                                      //Define o tipo de relacionamento
    @JoinColumn(name = "user_id")                   // Define qual será a FK
    private User client;

    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;

    public Order() {
    }

    public Order(Integer id, Instant moment, OrderStatus order, User client) {
        this.id = id;
        this.moment = moment;
        this.setOrder(order);
        this.client = client;
    }

    public Integer getId() {
        return id;
    }

    public Instant getMoment() {
        return moment;
    }

    public User getClient() {
        return client;
    }

    public OrderStatus getOrder() {
        return OrderStatus.valueOf(orderStatus);
    }

    public Payment getPayment(){
        return this.payment;
    }

    public Set<OrderItem> getItems(){
        return items;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public void setOrder(OrderStatus order) {
        if(order != null) {
            this.orderStatus = order.getCode();
        }
    }

    public void setPayment(Payment payment){
        this.payment = payment;
    }

    public Double getTotal(){
        double sum = 0;
        for(OrderItem item : items){
            sum += item.getSubtotal();
        }
        return sum;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

}
