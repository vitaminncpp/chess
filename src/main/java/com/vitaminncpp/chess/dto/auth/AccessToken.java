package com.vitaminncpp.chess.dto.auth;

import lombok.*;

@Builder
@Getter
@Setter
@ToString
public class AccessToken {
    private String accessToken = null;
    private String refreshToken = null;
}
