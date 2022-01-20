package com.example.pizzeriaapp.repository;

import com.example.pizzeriaapp.model.dao.rating.RatingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RatingRepository extends JpaRepository<RatingEntity, Long> {

    Optional<List<RatingEntity>> findByPizzaId(Long pizzaId);

}
