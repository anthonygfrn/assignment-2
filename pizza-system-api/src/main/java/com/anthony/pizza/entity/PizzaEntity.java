package com.anthony.pizza.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "pizzas")
public class PizzaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String pizzaName;
    private int quantity;
}
