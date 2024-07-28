package com.vitaminncpp.chess.services.auth;

import com.vitaminncpp.chess.entities.User;
import com.vitaminncpp.chess.services.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public User register(String username, String password, String email, String name) {
        User user = User.builder()
                .username(username)
                .name(name)
                .password(passwordEncoder.encode(password))
                .email(email)
                .build();
        return userService.save(user);
    }

    public User accessToken(String username, String password) {
        return null;
    }
}
