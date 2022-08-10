// This file was used during testing login without JWT

//package com.ingreedy.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
//        http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
//                .anyRequest().authenticated()
//                .and().httpBasic();
//
//        http.headers().frameOptions().sameOrigin();
//
//        return http.build();
//    }
//
//}
