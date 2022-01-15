package com.example.pizzeriaapp.service.converters;

import com.example.pizzeriaapp.model.dao.PizzaEntity;
import com.example.pizzeriaapp.model.dto.pizza.PizzaRequest;
import com.example.pizzeriaapp.model.dto.pizza.PizzaResponse;
import org.springframework.stereotype.Service;

@Service
public class PizzaConverter implements Convertable<PizzaRequest, PizzaEntity, PizzaResponse> {
    @Override
    public PizzaEntity fromDto(PizzaRequest pizzaRequest) {
        PizzaEntity pizzaEntity = new PizzaEntity();
        pizzaEntity.setName(pizzaRequest.getName());
        pizzaEntity.setDescription(pizzaRequest.getDescription());
        pizzaEntity.setSmallPrice(pizzaRequest.getSmallPrice());
        pizzaEntity.setMediumPrice(pizzaRequest.getMediumPrice());
        pizzaEntity.setBigPrice(pizzaRequest.getBigPrice());
        return pizzaEntity;
    }

    @Override
    public PizzaResponse toDto(PizzaEntity pizzaEntity) {
        return PizzaResponse.builder()
                .id(pizzaEntity.getId())
                .name(pizzaEntity.getName())
                .description(pizzaEntity.getDescription())
                .smallPrice(pizzaEntity.getSmallPrice())
                .mediumPrice(pizzaEntity.getMediumPrice())
                .bigPrice(pizzaEntity.getBigPrice())
                .build();
    }
}
