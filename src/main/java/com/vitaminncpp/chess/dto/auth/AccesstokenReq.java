package com.vitaminncpp.chess.dto.auth;

import com.vitaminncpp.chess.dto.Request;
import lombok.Getter;

@Getter
public class AccesstokenReq extends Request {
    private String username;
    private String password;
}
