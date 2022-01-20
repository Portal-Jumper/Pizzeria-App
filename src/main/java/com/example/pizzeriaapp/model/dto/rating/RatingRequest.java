package com.example.pizzeriaapp.model.dto.rating;

import lombok.Data;

@Data
public class RatingRequest {

    private Long pizzaId;
    private Long grade;
    private String content;
    private String user;

}
