package com.example.redis.domain.port.out;

import com.example.redis.domain.model.User;

public interface UserRepository {

    User getUserById(Long id);
}
