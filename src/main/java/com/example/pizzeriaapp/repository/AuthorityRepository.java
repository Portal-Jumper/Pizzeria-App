package com.example.pizzeriaapp.repository;

import com.example.pizzeriaapp.model.dao.users.AuthorityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<AuthorityEntity, Long> {
}
