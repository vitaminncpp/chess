package com.vitaminncpp.chess.dto;


import lombok.*;

@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Response {
    private int statusCode;
    private boolean success;
    private String message;
    private Object data;
}
