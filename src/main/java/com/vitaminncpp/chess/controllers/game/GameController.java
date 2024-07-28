package com.vitaminncpp.chess.controllers.game;


import com.vitaminncpp.chess.config.APIConfig;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(APIConfig.V_1 + APIConfig.GAME_URL)
public class GameController {
    @GetMapping(APIConfig.START)
    public ResponseEntity<String> startGame(RequestEntity<Void> request) {
        System.out.println("startGame");
        return ResponseEntity.ok("Authenticated User Game Start API call");
    }
}
