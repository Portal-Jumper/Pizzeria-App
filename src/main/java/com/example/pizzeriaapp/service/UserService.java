package com.example.pizzeriaapp.service;

import com.example.pizzeriaapp.model.dao.users.UserEntity;
import com.example.pizzeriaapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserEntity saveUser(UserEntity userEntity) {
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        return userRepository.save(userEntity);
    }

    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity user = userRepository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException(username));


        return User.builder()
                .username(user.getMail())
                .password(user.getPassword())
                .accountLocked(!user.isActive())
                .authorities(user.getAuthorities()
                        .stream().map(x -> x.getName())
                        .toArray(String[]::new))
                .build();
    }
}
