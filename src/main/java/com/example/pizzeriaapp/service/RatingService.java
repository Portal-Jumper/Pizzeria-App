package com.example.pizzeriaapp.service;

import com.example.pizzeriaapp.model.dao.rating.RatingEntity;
import com.example.pizzeriaapp.model.dto.rating.RatingRequest;
import com.example.pizzeriaapp.repository.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingService {

    private final RatingRepository ratingRepository;

    public RatingEntity addRating(RatingRequest ratingRequest) {
        RatingEntity ratingEntity = new RatingEntity();
        ratingEntity.setPizzaId(ratingRequest.getPizzaId());
        ratingEntity.setGrade(ratingRequest.getGrade());
        ratingEntity.setContent(ratingRequest.getContent());
        ratingEntity.setUser(ratingRequest.getUser());
        return ratingRepository.save(ratingEntity);
    }

    public List<RatingEntity> findRatingForPizza(Long pizzaId) {
        return ratingRepository.findByPizzaId(pizzaId).orElseThrow(() -> new RuntimeException());
    }
}
