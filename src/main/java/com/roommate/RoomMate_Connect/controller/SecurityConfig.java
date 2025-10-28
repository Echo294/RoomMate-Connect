package com.roommate.RoomMate_Connect.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll() // temporarily allow everything
            )
            .formLogin(login -> login.disable()) // disable login redirect
            .httpBasic(basic -> basic.disable()); // disable HTTP Basic auth

        return http.build();
    }
}
