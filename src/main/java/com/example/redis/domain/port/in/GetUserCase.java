package com.example.redis.domain.port.in;

import com.example.redis.application.dto.GetUserResult;

public interface GetUserCase {

    GetUserResult getUser(Long userId);
}
