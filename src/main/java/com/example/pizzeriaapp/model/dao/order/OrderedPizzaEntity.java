package com.example.pizzeriaapp.model.dao.order;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "orderedPizza")
@Data
public class OrderedPizzaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    Long pizzaId;
    String name;
    String size;
    Double price;
}
