package com.project.projectOne.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "category")
    private Set<Product> product = new HashSet<>();


    public Category(){

    }

    public Category(Integer id, String name){
        this.Id = id;
        this.name = name;
    }

    public Integer getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

   public Set<Product> getProduct() {
        return product;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(getId(), category.getId()) && Objects.equals(getName(), category.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}
