package com.vitaminncpp.chess.security;

import com.vitaminncpp.chess.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    public SecurityConfig() {
        System.out.println("SecurityConfig");
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        System.out.println("SecurityConfig|SecurityFilterChain");
        http.cors(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(matchers -> matchers.requestMatchers("/public").permitAll()
                        .requestMatchers("private").authenticated()).formLogin(FormLoginConfigurer::getClass);
        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        System.out.println("SecurityConfig|passwordEncoder");
        return new PasswordEncoder() {

            @Override
            public String encode(CharSequence rawPassword) {
                return rawPassword.toString();
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return true;
            }
        };
    }

    @Bean
    public UserDetailsService userDetailsService() {
        System.out.println("SecurityConfig|userDetailsService");
        return new UserService();
    }

}
