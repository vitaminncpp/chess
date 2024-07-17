package com.vitaminncpp.chess.services.auth;

import com.vitaminncpp.chess.entities.User;
import com.vitaminncpp.chess.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserService userService;

    public User register(String username, String password, String email, String name) {
        User user = User.builder()
                .username(username)
                .name(name)
                .password(password)
                .email(email)
                .build();
        return userService.save(user);
    }

    public User login(String username, String password) {
        return null;
    }
}
