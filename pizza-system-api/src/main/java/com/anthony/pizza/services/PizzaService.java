package com.anthony.pizza.services;

import com.anthony.pizza.model.Pizza;

import java.util.List;

public interface PizzaService {
    Pizza createPizza(Pizza pizza);

    List<Pizza> getAllPizzas();
}
