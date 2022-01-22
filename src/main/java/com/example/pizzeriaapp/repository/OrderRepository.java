package com.example.pizzeriaapp.repository;

import com.example.pizzeriaapp.model.dao.order.OrderEntity;
import com.example.pizzeriaapp.model.dao.users.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {


    Optional<List<OrderEntity>> findByUser(UserEntity user);
}
