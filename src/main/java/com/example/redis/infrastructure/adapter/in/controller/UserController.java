package com.example.redis.infrastructure.adapter.in.controller;

import com.example.redis.application.dto.GetUserResult;
import com.example.redis.application.service.GetUserService;
import com.example.redis.domain.port.in.GetUserCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final GetUserCase getUserCase;

    @GetMapping("/{userId}")
    public GetUserResult getUserResponse(@PathVariable Long userId ) {
        return getUserCase.getUser(userId);
    }
}
