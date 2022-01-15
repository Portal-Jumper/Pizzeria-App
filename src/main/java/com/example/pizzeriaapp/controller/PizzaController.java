package com.example.pizzeriaapp.controller;

import com.example.pizzeriaapp.model.dto.pizza.PizzaResponse;
import com.example.pizzeriaapp.service.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200/")
@Transactional
public class PizzaController {

    private final PizzaService pizzaService;

    @GetMapping(path = "/menu")
    public List<PizzaResponse> getDynamicPizzaName(@RequestParam(required = false) String query){
        return pizzaService.getMenu(query);
    }
}
