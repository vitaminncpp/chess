package com.vitaminncpp.chess.controllers.auth;

import com.vitaminncpp.chess.dto.auth.RegisterRequest;
import com.vitaminncpp.chess.dto.auth.RegisterResponse;
import com.vitaminncpp.chess.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vitaminncpp.chess.config.APIConfig;

@RestController
@RequestMapping(APIConfig.V_1 + APIConfig.AUTHENTICATION_URL)
public class AuthController {
    @PostMapping(APIConfig.REGISTER_URL)
    @ResponseBody
    public ResponseEntity<RegisterResponse> register(@RequestBody final RegisterRequest register) {
        RegisterResponse response = new RegisterResponse();
        response.setData(new User());
        return ResponseEntity.ok(new RegisterResponse());
    }
}
