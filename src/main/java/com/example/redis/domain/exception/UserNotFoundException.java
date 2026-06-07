package com.example.redis.domain.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserNotFoundException extends RuntimeException {

    private String code;

    private String message;

}
