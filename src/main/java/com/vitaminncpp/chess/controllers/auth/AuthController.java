package com.vitaminncpp.chess.controllers.auth;

import com.vitaminncpp.chess.dto.auth.RegisterRequest;
import com.vitaminncpp.chess.dto.auth.RegisterResponse;
import com.vitaminncpp.chess.entities.User;
import com.vitaminncpp.chess.services.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vitaminncpp.chess.config.APIConfig;

@RestController
@RequestMapping(APIConfig.V_1 + APIConfig.AUTHENTICATION_URL)
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping(APIConfig.REGISTER_URL)
    @ResponseBody
    public ResponseEntity<RegisterResponse> register(@RequestBody final RegisterRequest request) {
        System.out.println(request.toString());
        RegisterResponse response = new RegisterResponse();
        response.setData(authService.register(request.getUsername(), request.getPassword(), request.getEmail(), request.getName()));
        return ResponseEntity.ok(response);
    }

    @GetMapping(APIConfig.REGISTER_URL + "1")
    @ResponseBody
    public ResponseEntity<RegisterResponse> registerGet() {
        RegisterResponse response = new RegisterResponse();
        response.setData(new User());
        return ResponseEntity.ok(response);
    }
}
