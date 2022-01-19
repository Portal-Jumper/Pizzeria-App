package com.example.pizzeriaapp.service;

import com.example.pizzeriaapp.model.dao.order.OrderEntity;
import com.example.pizzeriaapp.model.dao.order.OrderedPizzaEntity;
import com.example.pizzeriaapp.model.dao.users.UserEntity;
import com.example.pizzeriaapp.model.dto.order.OrderRequest;
import com.example.pizzeriaapp.model.dto.order.OrderedPizza;
import com.example.pizzeriaapp.repository.OrderRepository;
import com.example.pizzeriaapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderEntity saveOrder(OrderRequest orderRequest) {

        Long price = 0L;

        UserEntity user = userRepository.findByUsername(orderRequest.getUsername())
                .orElseThrow(() -> new RuntimeException());

        for (OrderedPizza el: orderRequest.getPizzaList()) {
            price += el.getPrice();
        }

        List<OrderedPizzaEntity> orderedPizzas = orderRequest.getPizzaList().stream()
                .map(x -> {
                    OrderedPizzaEntity orderedPizzaEntity = new OrderedPizzaEntity();
                    orderedPizzaEntity.setPizzaId(x.getPizzaId());
                    orderedPizzaEntity.setName(x.getName());
                    orderedPizzaEntity.setSize(x.getSize());
                    orderedPizzaEntity.setPrice(x.getPrice());
                    return orderedPizzaEntity;
                }).collect(Collectors.toList());

        OrderEntity order = new OrderEntity();
        order.setOrderedPizzas(orderedPizzas);
        order.setDeliveryType(orderRequest.getOrderType());
        order.setName(user.getName());
        order.setSurname(user.getSurname());
        order.setStreet(user.getStreet());
        order.setStreetNumber(user.getStreetNumber());
        order.setCity(user.getCity());
        order.setPostalCode(user.getPostalCode());
        order.setPhoneNumber(user.getPhoneNumber());
        order.setPrice(price);

        return orderRepository.save(order);
    }

}
