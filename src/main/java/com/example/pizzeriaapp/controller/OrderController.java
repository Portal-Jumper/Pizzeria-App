package com.example.pizzeriaapp.controller;

import com.example.pizzeriaapp.model.dao.order.OrderEntity;
import com.example.pizzeriaapp.model.dto.order.OrderRequest;
import com.example.pizzeriaapp.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class OrderController {

    private final OrderService orderService;

    @PostMapping(path = "/addOrder")
    public OrderEntity addOrder(@RequestBody OrderRequest order) {
        return orderService.saveOrder(order);
    }

}
