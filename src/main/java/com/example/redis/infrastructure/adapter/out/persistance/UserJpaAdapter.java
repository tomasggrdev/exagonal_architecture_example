package com.example.redis.infrastructure.adapter.out.persistance;

import com.example.redis.domain.exception.UserNotFoundException;
import com.example.redis.domain.model.User;
import com.example.redis.domain.port.out.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserJpaAdapter implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    private final UserPersistenceMapper userPersistenceMapper;


    @Override
    public User getUserById(Long id) {

        return userJpaRepository.findById(id)
                .map(userPersistenceMapper::toDomain)
                .orElseThrow(() -> new UserNotFoundException("NOT_FOUND", "user not found"));
    }
}
