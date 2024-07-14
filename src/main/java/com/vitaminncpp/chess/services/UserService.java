package com.vitaminncpp.chess.services;

import com.vitaminncpp.chess.entities.User;
import com.vitaminncpp.chess.repositories.IUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    private final IUserRepository repository;

    public UserService(IUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println();
        Optional<User> user = this.repository.findByUsername(username);
        System.out.println(user);
        return user.get();
    }
}
