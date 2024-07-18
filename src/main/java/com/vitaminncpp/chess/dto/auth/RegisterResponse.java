package com.vitaminncpp.chess.dto.auth;

import com.vitaminncpp.chess.dto.Response;
import com.vitaminncpp.chess.entities.User;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RegisterResponse extends Response {
    private User data;
}
