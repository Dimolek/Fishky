package com.fishky.mapper;

import com.fishky.config.AccountRoles;
import com.fishky.dto.user.UserCreateRequestDto;
import com.fishky.dto.user.UserDto;
import com.fishky.model.UserEntity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class UserMapper {

    public static UserEntity fromDto(final UserCreateRequestDto user) {
        return new UserEntity(
                user.getUsername(),
                user.getPassword(),
                Timestamp.valueOf(LocalDateTime.now()),
                AccountRoles.USER);
    }

    public static UserEntity fromDto(UserDto user, LocalDateTime creationTime) {
        return new UserEntity(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                Timestamp.valueOf(creationTime),
                AccountRoles.USER);
    }

    public static UserDto toDto(final UserEntity user) {
        return UserDto.of(
                user.getIdUser(),
                user.getUsername(),
                user.getPassword());
    }
}
