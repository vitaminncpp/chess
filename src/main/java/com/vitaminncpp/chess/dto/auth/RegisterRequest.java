package com.vitaminncpp.chess.dto.auth;

import com.vitaminncpp.chess.dto.Request;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RegisterRequest extends Request {
    private String email;
    private String username;
    private String password;
    private String name;
}
