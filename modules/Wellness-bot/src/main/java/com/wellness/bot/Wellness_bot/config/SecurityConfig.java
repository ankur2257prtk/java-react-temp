package com.wellness.bot.Wellness_bot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .csrf(csrf -> csrf.disable())  // ✅ Updated for Spring Security 6.1+
            .authorizeHttpRequests(auth -> auth.anyRequest().permitAll())  // ✅ Allows all requests
            .build();
    }
}
