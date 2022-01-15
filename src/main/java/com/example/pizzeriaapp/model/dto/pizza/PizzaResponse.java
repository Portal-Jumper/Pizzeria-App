package com.example.pizzeriaapp.model.dto.pizza;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PizzaResponse {

    private Long id;
    private String name;
    private String description;
    private Double smallPrice;
    private Double mediumPrice;
    private Double bigPrice;
}
