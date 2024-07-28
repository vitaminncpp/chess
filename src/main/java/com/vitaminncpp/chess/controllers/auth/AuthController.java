package com.vitaminncpp.chess.controllers.auth;

import com.vitaminncpp.chess.data.Messages;
import com.vitaminncpp.chess.dto.Response;
import com.vitaminncpp.chess.dto.auth.AccessToken;
import com.vitaminncpp.chess.dto.auth.AccesstokenReq;
import com.vitaminncpp.chess.dto.auth.RegisterRequest;
import com.vitaminncpp.chess.entities.User;
import com.vitaminncpp.chess.services.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
    public ResponseEntity<Response> register(final RequestEntity<RegisterRequest> request) {
        final RegisterRequest body = request.getBody();
        if (body == null) {
            Response res = Response
                    .builder()
                    .data(null)
                    .success(false)
                    .statusCode(422)
                    .message(Messages.REQUEST_BODY_REQUIRED)
                    .build();
            return ResponseEntity.status(422).body(res);
        }
        User user = authService.register(body.getUsername(), body.getPassword(), body.getEmail(), body.getName());
        if (user != null) {
            return ResponseEntity.ok(Response
                    .builder().data(user)
                    .statusCode(200).success(true)
                    .message(Messages.USER_REGISTERED_SUCCESSFULLY)
                    .build());
        }
        return ResponseEntity.status(409).body(Response
                .builder().data(null)
                .statusCode(409).success(false)
                .message(Messages.USER_ALREADY_EXISTS)
                .build());

    }

    @PostMapping(APIConfig.ACCESS_TOKEN)
    @ResponseBody
    public ResponseEntity<Response> accessToken(final RequestEntity<AccesstokenReq> request) {
        try {
            AccessToken token = this.authService.accessToken(request.getBody().getUsername(), request.getBody().getPassword());
            if (token == null) {
                return ResponseEntity.ok(Response
                        .builder().statusCode(401)
                        .success(false).message(Messages.INCORRECT_PASSWORD)
                        .data(null)
                        .build());
            }
            return ResponseEntity.ok(Response
                    .builder().statusCode(200)
                    .success(true).message(Messages.GET_ACCESS_TOKEN)
                    .data(token)
                    .build());
        } catch (UsernameNotFoundException ex) {
            return ResponseEntity.ok(Response
                    .builder().statusCode(404)
                    .success(true).message(Messages.USER_NOT_EXISTS)
                    .data(null)
                    .build());
        }
    }
}
