package com.vitaminncpp.chess.services;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.List;

public class UserService implements UserDetailsService {

    public UserService() {
        System.out.println("UserService");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("UserService|loadUserByUsername");
        return new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return List.of(new SimpleGrantedAuthority("ROLE_USER"));
            }

            @Override
            public String getPassword() {
                System.out.println("UserService|getPassword");
                return username;
            }

            @Override
            public String getUsername() {
                System.out.println("UserService|getUsername");
                System.out.println(username);
                return username;
            }
        };
    }
}
