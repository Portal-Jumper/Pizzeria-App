package com.example.pizzeriaapp.model.dao.users;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "authorities")
@Data
public class AuthorityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

}
