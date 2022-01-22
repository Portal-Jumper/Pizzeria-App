package com.example.pizzeriaapp.model.dto.order;

import lombok.Data;

@Data
public class OrderedPizza {

    Long pizzaId;
    String name;
    String size;
    Double price;

}
