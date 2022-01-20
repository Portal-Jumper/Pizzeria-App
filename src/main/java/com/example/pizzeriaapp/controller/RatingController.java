package com.example.pizzeriaapp.controller;

import com.example.pizzeriaapp.model.dao.rating.RatingEntity;
import com.example.pizzeriaapp.model.dto.rating.RatingRequest;
import com.example.pizzeriaapp.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class RatingController {

    private final RatingService ratingService;

    @GetMapping(path = "/getPizzaRating/{id}")
    public List<RatingEntity> getPizzaRatingById(@PathVariable(name = "id") Long id) {
        return ratingService.findRatingForPizza(id);
    }

    @PostMapping(path = "/addRating")
    public RatingEntity addOrder(@RequestBody RatingRequest ratingRequest) {
        return ratingService.addRating(ratingRequest);
    }

}
