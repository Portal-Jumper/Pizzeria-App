package com.example.pizzeriaapp.model.dto.user;

import lombok.Data;

@Data
public class UserRequest {

    private String username;
    private String password;
    private String phoneNumber;
    private String mail;
    private String name;
    private String surname;
    private String street;
    private String streetNumber;
    private String City;
    private String postalCode;
}
