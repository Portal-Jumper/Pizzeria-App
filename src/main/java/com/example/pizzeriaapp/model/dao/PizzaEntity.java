package com.example.pizzeriaapp.model.dao;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Pizza")
@Data
public class PizzaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

    @Column(name = "Small_Price")
    private Double smallPrice;

    @Column(name = "Medium_Price")
    private Double mediumPrice;

    @Column(name = "Big_Price")
    private Double bigPrice;
}
