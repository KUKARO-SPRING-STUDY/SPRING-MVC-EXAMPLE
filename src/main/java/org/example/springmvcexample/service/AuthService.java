package org.example.springmvcexample.service;

import lombok.extern.slf4j.Slf4j;
import org.example.springmvcexample.dto.UserDto;
import org.example.springmvcexample.entity.UserEntity;
import org.example.springmvcexample.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

@Slf4j
public class AuthService implements UserDetailsService {
    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean login(String id, String password) {
        return id.equals("groom") && password.equals("groom");
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        log.info("ACCESS LOGIN : {}", email);
        Optional<UserEntity> optionalUserEntity = userRepository.findUsersByEmail(email);
        return optionalUserEntity
                .map(userEntity -> new UserDto(userEntity.getId(), userEntity.getEmail(), userEntity.getPassword(), userEntity.getName()))
                .orElseThrow(() -> new RuntimeException("User가 없습니다."));
    }
}
