package com.example.redis.application.service;

import com.example.redis.application.dto.GetUserResult;
import com.example.redis.domain.model.User;
import com.example.redis.domain.port.in.GetUserCase;
import com.example.redis.domain.port.out.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetUserService implements GetUserCase {

    private final UserRepository userRepository;

    @Override
    public GetUserResult getUser(Long userId) {
        User user = userRepository.getUserById(userId);
        return new GetUserResult(user.getId(), user.getFirstName(),user.getLastName(), user.getDNI());
    }

}
