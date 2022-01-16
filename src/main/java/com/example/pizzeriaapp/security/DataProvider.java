package com.example.pizzeriaapp.security;

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
    public void run(String... args) throws Exception {

        AuthorityEntity userRole = new AuthorityEntity();
        userRole.setName("ROLE_ADMIN");
        userRole = authorityRepository.save(userRole);

        UserEntity user = new UserEntity();
        user.setNickname("Admin");
        user.setMail("Admin@gmail.com");
        user.setPassword(passwordEncoder.encode("Admin123"));
        user.setActive(true);
        user.setAuthorities(Arrays.asList(userRole));
        userRepository.save(user);
    }
}
