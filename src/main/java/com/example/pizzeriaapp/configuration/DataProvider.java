package com.example.pizzeriaapp.configuration;

import com.example.pizzeriaapp.model.dao.users.AuthorityEntity;
import com.example.pizzeriaapp.model.dao.users.UserEntity;
import com.example.pizzeriaapp.repository.AuthorityRepository;
import com.example.pizzeriaapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class DataProvider implements CommandLineRunner {

    private final AuthorityRepository authorityRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {

        AuthorityEntity adminRole = new AuthorityEntity();
        adminRole.setName("ROLE_ADMIN");
        adminRole = authorityRepository.save(adminRole);

        AuthorityEntity userRole = new AuthorityEntity();
        userRole.setName("ROLE_USER");
        userRole = authorityRepository.save(userRole);

        UserEntity admin = new UserEntity();
        admin.setUsername("Admin");
        admin.setPassword(passwordEncoder.encode("Admin123"));
        admin.setActive(true);
        admin.setAuthorities(Arrays.asList(adminRole));
        userRepository.save(admin);

        UserEntity testUser = new UserEntity();
        testUser.setUsername("Marek12");
        testUser.setPassword(passwordEncoder.encode("Marek12"));
        testUser.setPhoneNumber("+48 593-123-956");
        testUser.setMail("Marek12@gmail.com");
        testUser.setName("Marek");
        testUser.setSurname("Nowak");
        testUser.setStreet("Kolejowa");
        testUser.setStreetNumber("12/85");
        testUser.setCity("Warszawa");
        testUser.setPostalCode("01-205");
        testUser.setActive(true);
        testUser.setAuthorities(Arrays.asList(userRole));
        userRepository.save(testUser);
    }
}
