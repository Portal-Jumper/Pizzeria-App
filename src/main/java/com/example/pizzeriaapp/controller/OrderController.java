package com.example.pizzeriaapp.controller;

import com.example.pizzeriaapp.model.dao.order.OrderEntity;
import com.example.pizzeriaapp.model.dto.order.OrderRequest;
import com.example.pizzeriaapp.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class OrderController {

    private final OrderService orderService;

    @PostMapping(path = "/addOrder")
    public OrderEntity addOrder(@RequestBody OrderRequest order) {
        return orderService.saveOrder(order);
    }
    @Transactional
    @GetMapping(path = "/orders")
    public List<OrderEntity> getOrdersByUsername(Principal principal){
        return orderService.getOrderHistoryFromUser(principal.getName());
    }

    @GetMapping(path = "/allOrders")
    public List<OrderEntity> getAllOrders(){
        return orderService.getOrderHistory();
    }



}
