package com.project.projectOne.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.projectOne.entities.pk.OrderItemPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "order_item")
public class OrderItem implements Serializable {

    @EmbeddedId             // Identidifica o campo como referência para outra classe que implementa uma PK composta
    private OrderItemPK id = new OrderItemPK();   //Sempre que uma classe auxiliar foi implementada, esta deve ser instanciada, pois esta instanciação nunca é realizada durante a execução do programa!!!

    private Integer quantity;
    private Double price;


    public OrderItem(){

    }

    public OrderItem(Order order, Product product, Integer quantity, Double price){
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    @JsonIgnore
    public Order getOrder(){
        return id.getOrder();
    }


    public Product getProduct(){
        return id.getProduct();
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setOrder(Order order) {
        id.setOrder(order);
    }

    public void setProduct(Product product) {
        id.setProduct(product);
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getSubtotal(){
        return price * quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id) && Objects.equals(getQuantity(), orderItem.getQuantity()) && Objects.equals(getPrice(), orderItem.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
