package com.vitaminncpp.chess.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class AppProperties {
    @Value("${application.config.jwtSecret}")
    private String jwtSecret;
}
