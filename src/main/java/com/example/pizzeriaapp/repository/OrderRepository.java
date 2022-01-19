package com.example.pizzeriaapp.repository;

import com.example.pizzeriaapp.model.dao.order.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
