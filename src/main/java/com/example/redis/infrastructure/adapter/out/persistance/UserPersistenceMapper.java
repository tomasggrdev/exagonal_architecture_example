package com.example.redis.infrastructure.adapter.out.persistance;

import com.example.redis.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserPersistenceMapper {

    public UserEntity toEntity(User user) {
        return UserEntity.builder()
                .id(user.getId())
                .dni(user.getDNI())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }

    public User toDomain(UserEntity userEntity) {
        return User.builder()
                .id(userEntity.getId())
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .DNI(userEntity.getDni())
                .build();
    }
}
