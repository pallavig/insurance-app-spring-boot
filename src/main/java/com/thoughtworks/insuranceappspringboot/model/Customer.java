package com.thoughtworks.insuranceappspringboot.model;

import javax.persistence.*;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    public Customer(String name) {
        this.id = id;
        this.name = name;
    }

    public Customer() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
