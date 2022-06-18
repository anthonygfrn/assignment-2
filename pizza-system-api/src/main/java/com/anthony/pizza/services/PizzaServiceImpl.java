package com.anthony.pizza.services;

import com.anthony.pizza.entity.PizzaEntity;
import com.anthony.pizza.model.Pizza;
import com.anthony.pizza.repository.PizzaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PizzaServiceImpl implements PizzaService{

    private PizzaRepository pizzaRepository;

    public PizzaServiceImpl(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    @Override
    public Pizza createPizza(Pizza pizza) {
        PizzaEntity pizzaEntity = new PizzaEntity();

        BeanUtils.copyProperties(pizza, pizzaEntity);
        pizzaRepository.save(pizzaEntity);
        return pizza;
    }

    @Override
    public List<Pizza> getAllPizzas() {
        List<PizzaEntity> pizzaEntities
                = pizzaRepository.findAll();

        List<Pizza> pizzas = pizzaEntities
                .stream()
                .map(emp -> new Pizza(
                        emp.getId(),
                        emp.getPizzaName(),
                        emp.getQuantity()))
                .collect(Collectors.toList());
        return pizzas;
    }
}
