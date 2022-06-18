package com.anthony.pizza.controller;

import com.anthony.pizza.model.Pizza;
import com.anthony.pizza.services.PizzaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/api/v1/")
public class PizzaController {

    private final PizzaService pizzaservice;

    public PizzaController(PizzaService pizzaservice) {
        this.pizzaservice = pizzaservice;
    }
    @PostMapping("/pizzas")
    public Pizza createPizza(@RequestBody Pizza pizza) {
        return pizzaservice.createPizza(pizza);
    }

    @GetMapping("/pizzas")
    public List<Pizza> getAllEmployees() {
        return  pizzaservice.getAllPizzas();
    }
}
