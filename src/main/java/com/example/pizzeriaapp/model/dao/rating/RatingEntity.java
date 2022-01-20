package com.example.pizzeriaapp.model.dao.rating;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ratings")
@Data
public class RatingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long pizzaId;
    private Long grade;
    private String content;
    private String user;

}
