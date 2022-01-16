package com.example.pizzeriaapp.model.dao.users;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickname;

    private String password;

    private String mail;

    private boolean active;

    @ManyToMany
    List<AuthorityEntity> authorities;
}
