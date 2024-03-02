package org.example.springmvcexample.config;

import lombok.extern.slf4j.Slf4j;
import org.example.springmvcexample.repository.UserRepository;
import org.example.springmvcexample.service.AuthService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Slf4j
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    private final UserRepository userRepository;

    public SecurityConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new AuthService(userRepository);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authz) -> authz
                                .requestMatchers("/old/*").permitAll()
//                        .requestMatchers("/index").hasRole("USER") // 이렇게도 설정가능
                                .anyRequest()
                                .authenticated()
                )
                .formLogin((login) -> login
                        .loginPage("/login") // 이거 설정안하면 기본이 login
                        .loginProcessingUrl("/login-process") // 이거 설정안하면 기본이 login
                        .usernameParameter("email")
                        .passwordParameter("password")
                        .defaultSuccessUrl("/index")
                        .failureHandler((request, response, authenticationException) -> {
                            log.info("LOGIN FAIL");
                            log.info(authenticationException.toString());
                        })
                        .permitAll()
                )
//                .logout((logout) -> logout
//                        .logoutUrl("/logout")
//                        .permitAll())
//                .sessionManagement((session) -> session
//                        .sessionFixation().changeSessionId())
//                .httpBasic(withDefaults())
                .build();
    }

    /**
     * 이건 비권장이고 위의 /old처럼 해야함
     */
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring()
                .requestMatchers("/auth/*")
                .requestMatchers("/api/user", "/api/users", "/api/user/*");
    }
}