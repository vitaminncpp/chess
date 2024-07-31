package com.vitaminncpp.chess.controllers.publicGame;

import com.vitaminncpp.chess.config.APIConfig;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("PublicGameController")
@RequestMapping(APIConfig.V_1 + APIConfig.PUBLIC_URL + APIConfig.GAME_URL)
public class GameController {

    @GetMapping(APIConfig.START)
    ResponseEntity<String> startGame(RequestEntity<Void> request) {
        System.out.println("startGamePublic");
        return ResponseEntity.ok("Public Game start API call");
    }
}
