package com.alkemy.disneylandia.disneylandia.authorization.service;

import com.alkemy.disneylandia.disneylandia.authorization.dto.UserDto;
import com.alkemy.disneylandia.disneylandia.authorization.entity.UserEntity;
import com.alkemy.disneylandia.disneylandia.authorization.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;

@Service
public class UserDetailsCustomService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    EmailService emailService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException("Username or password not found");
        }
        return new User(userEntity.getUsername(), userEntity.getPassword(), Collections.emptyList());
    }

    public boolean save(UserDto userDto) throws IOException {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userDto.getUsername());
        userEntity.setPassword(userDto.getPassword());
        userEntity = userRepository.save(userEntity);
//        if (userEntity != null) {
//            emailService.sendWelcomeEmailTo(userEntity.getUsername());
//        }
        return userEntity != null;
    }
}