package com.fishky.adapter.implementation;

import com.fishky.adapter.UserAdapter;
import com.fishky.dto.user.UserCreateDto;
import com.fishky.dto.user.UserDto;
import com.fishky.model.UserEntity;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Component
public class UserAdapterImpl implements UserAdapter {

    @Override
    public UserEntity fromDto(final UserCreateDto user) {
        return new UserEntity(
                user.getUsername(),
                user.getPassword(),
                Timestamp.valueOf(LocalDateTime.now()));
    }

    @Override
    public UserEntity fromDto(UserDto user, LocalDateTime creationTime) {
        return new UserEntity(
                Long.parseLong(user.getId()),
                user.getUsername(),
                user.getPassword(),
                Timestamp.valueOf(creationTime));
    }

    @Override
    public UserDto toDto(final UserEntity user) {
        return UserDto.of(
                String.valueOf(user.getIdUser()),
                user.getUsername(),
                user.getPassword());
    }
}
