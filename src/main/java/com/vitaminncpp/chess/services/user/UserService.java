package com.vitaminncpp.chess.services.user;

import com.vitaminncpp.chess.entities.User;
import com.vitaminncpp.chess.repositories.IUserRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Getter
@Setter
public class UserService implements UserDetailsService {
    private final IUserRepository repository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println();
        Optional<User> user = this.repository.findByUsername(username);
        System.out.println(user);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new UsernameNotFoundException(username);
        }
    }

    public User save(User user) {
        return this.repository.save(user);
    }
}
