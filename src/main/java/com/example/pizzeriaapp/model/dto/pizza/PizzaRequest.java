package com.example.pizzeriaapp.model.dto.pizza;

import lombok.Data;

@Data
public class PizzaRequest {

    private String name;
    private String description;
    private Double smallPrice;
    private Double mediumPrice;
    private Double bigPrice;
}
