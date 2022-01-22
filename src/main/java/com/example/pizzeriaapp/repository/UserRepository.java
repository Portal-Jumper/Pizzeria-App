package com.example.pizzeriaapp.repository;

import com.example.pizzeriaapp.model.dao.users.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);


}
