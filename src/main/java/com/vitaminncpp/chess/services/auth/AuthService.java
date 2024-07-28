package com.vitaminncpp.chess.services.auth;

import com.vitaminncpp.chess.dto.auth.AccessToken;
import com.vitaminncpp.chess.entities.User;
import com.vitaminncpp.chess.services.jwt.JwtService;
import com.vitaminncpp.chess.services.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public User register(String username, String password, String email, String name) {
        User user = User.builder()
                .username(username)
                .name(name)
                .password(passwordEncoder.encode(password))
                .email(email)
                .build();
        return this.userService.save(user);
    }

    public AccessToken accessToken(String username, String password) throws UsernameNotFoundException {
        User user = null;
        user = (User) this.userService.loadUserByUsername(username);
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        if (passwordEncoder.matches(password, user.getPassword())) {
            user.setPassword(null);
            String accessToken = jwtService.generateAccessToken(user, Map.of("email", user.getEmail(), "username", user.getUsername(), "id", user.getId()));
            String refreshToken = jwtService.generateRefreshToken(user, Map.of("email", user.getEmail(), "username", user.getUsername(), "id", user.getId()));
            return AccessToken
                    .builder()
                    .accessToken(accessToken)
                    .refreshToken(refreshToken)
                    .build();
        } else {
            return null;
        }
    }
}
