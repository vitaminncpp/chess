package com.vitaminncpp.chess.controllers.auth;

import com.vitaminncpp.chess.dto.auth.RegisterRequest;
import com.vitaminncpp.chess.dto.auth.RegisterResponse;
import com.vitaminncpp.chess.entities.User;
import com.vitaminncpp.chess.services.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vitaminncpp.chess.config.APIConfig;

@RestController
@RequestMapping(APIConfig.V_1 + APIConfig.AUTHENTICATION_URL)
@RequiredArgsConstructor
public class AuthController {
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
    private final AuthService authService;

    @PostMapping(APIConfig.REGISTER_URL)
    @ResponseBody
    public ResponseEntity<RegisterResponse> register(@RequestBody final RegisterRequest request) {
        RegisterResponse response = new RegisterResponse();
        User user = authService.register(request.getUsername(), request.getPassword(), request.getEmail(), request.getName());
        response.setData(user);
        return ResponseEntity.ok(response);
    }

    @GetMapping(APIConfig.ACCESS_TOKEN)
    @ResponseBody
    public ResponseEntity<RegisterResponse> registerGet() {
        RegisterResponse response = new RegisterResponse();
        response.setData(new User());
        return ResponseEntity.ok(response);
    }
}
