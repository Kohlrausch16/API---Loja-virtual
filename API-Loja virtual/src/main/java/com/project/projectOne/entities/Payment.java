package com.project.projectOne.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "payment")
public class Payment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Instant moment;

    @JsonIgnore
    @OneToOne
    @MapsId         // Implementada na classe dependente (aquela que sozinha não tem sentido)
    private Order order;

    public Payment(){

    }

    public Payment(Integer id, Instant moment, Order order){
        this.id = id;
        this.moment = moment;
        this.order = order;
    }

    public Integer getId() {
        return id;
    }

    public Instant getMoment() {
        return moment;
    }

    public Order getOrder() {
        return order;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(getId(), payment.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
