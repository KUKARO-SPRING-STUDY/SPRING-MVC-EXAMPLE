package org.example.springmvcexample.service;

import org.example.springmvcexample.entity.UserEntity;
import org.example.springmvcexample.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserEntity saveUser(UserEntity user) {
        return userRepository.save(user.encodePassword(passwordEncoder));
    }

    public List<UserEntity> findAllUser() {
        return userRepository.findAll();
    }

    public boolean deleteAllUser() {
        try {
            userRepository.deleteAll();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
