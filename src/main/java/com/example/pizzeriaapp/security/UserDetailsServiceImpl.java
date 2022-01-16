package com.example.pizzeriaapp.security;

import com.example.pizzeriaapp.model.dao.users.UserEntity;
import com.example.pizzeriaapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {


    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity user = userRepository.findByNicknameOrMail(username).orElseThrow(() ->
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
