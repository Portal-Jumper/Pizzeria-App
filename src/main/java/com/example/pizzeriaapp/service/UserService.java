package com.example.pizzeriaapp.service;

import com.example.pizzeriaapp.model.dao.users.UserEntity;
import com.example.pizzeriaapp.model.dto.user.UserRequest;
import com.example.pizzeriaapp.repository.AuthorityRepository;
import com.example.pizzeriaapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder passwordEncoder;

    public UserEntity saveUser(UserRequest userRequest) {
        UserEntity user = new UserEntity();
        user.setUsername(userRequest.getUsername());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        user.setPhoneNumber(userRequest.getPhoneNumber());
        user.setMail(userRequest.getMail());
        user.setName(userRequest.getName());
        user.setSurname(userRequest.getSurname());
        user.setStreet(userRequest.getStreet());
        user.setStreetNumber(userRequest.getStreetNumber());
        user.setCity(userRequest.getCity());
        user.setPostalCode(userRequest.getPostalCode());
        user.setActive(true);
        user.setAuthorities(Arrays.asList(authorityRepository.findByName("ROLE_USER").orElseThrow(
                () -> new RuntimeException()
        )));
        return userRepository.save(user);
    }

    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity user = userRepository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException(username));


        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .accountLocked(!user.isActive())
                .authorities(user.getAuthorities()
                        .stream().map(x -> x.getName())
                        .toArray(String[]::new))
                .build();
    }
}
