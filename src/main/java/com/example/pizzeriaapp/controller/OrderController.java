package com.example.pizzeriaapp.controller;

import com.example.pizzeriaapp.model.dao.OrderEntity;
import com.example.pizzeriaapp.model.dao.PizzaEntity;
import com.example.pizzeriaapp.repository.OrderRepository;
import com.example.pizzeriaapp.repository.PizzaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
@Transactional
public class OrderController {

    private final PizzaRepository pizzaRepository;
    private final OrderRepository orderRepository;

    @PostMapping()
    public void saveOrder() {
        PizzaEntity pizzaEntity = pizzaRepository.findById(1L).orElseThrow(() -> new RuntimeException());
        PizzaEntity pizzaEntity2 = pizzaRepository.findById(2L).orElseThrow(() -> new RuntimeException());
        PizzaEntity pizzaEntity3 = pizzaRepository.findById(3L).orElseThrow(() -> new RuntimeException());
        PizzaEntity pizzaEntity4 = pizzaRepository.findById(4L).orElseThrow(() -> new RuntimeException());
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderedPizza(List.of(pizzaEntity,pizzaEntity2,pizzaEntity3,pizzaEntity4));
        orderRepository.save(orderEntity);
    }

    @GetMapping
    public void getOrder() {
        System.out.println(orderRepository.findById(1L).orElseThrow(() -> new RuntimeException()));
    }
}
