package com.example.pizzeriaapp.model.dao.order;

import com.example.pizzeriaapp.model.dao.users.UserEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deliveryType;
    private String name;
    private String surname;
    private String street;
    private String streetNumber;
    private String city;
    private String postalCode;
    private String phoneNumber;
    private Double price;

    @ManyToMany(cascade = CascadeType.ALL)
    List<OrderedPizzaEntity> orderedPizzas;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

}
