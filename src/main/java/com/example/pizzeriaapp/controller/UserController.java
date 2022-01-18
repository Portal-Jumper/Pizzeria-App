package com.example.pizzeriaapp.controller;

import com.example.pizzeriaapp.model.dao.users.UserEntity;
import com.example.pizzeriaapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Transactional
public class UserController {

    private final UserService userService;

    @GetMapping("/api/users")
    public List<UserEntity> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("/api/addUser")
    public UserEntity saveUser(@RequestBody UserEntity user) {
        return userService.saveUser(user);
    }
}
