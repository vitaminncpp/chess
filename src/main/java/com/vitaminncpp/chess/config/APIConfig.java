package com.vitaminncpp.chess.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class APIConfig {
    public static final String V_1 = "/api/v1";
    public static final String ERROR = "/error";

    public static final String AUTHENTICATION_URL = "/auth";
    public static final String REGISTER_URL = "/register";
    public static final String ACCESS_TOKEN = "/access-token";

    public static final String PUBLIC_URL = "/public";
    public static final String GAME_URL = "/game";
    public static final String START = "/start";

}
