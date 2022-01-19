package com.example.pizzeriaapp.model.dto.order;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {

    List<OrderedPizza> pizzaList;
    String orderType;
    String username;

}
