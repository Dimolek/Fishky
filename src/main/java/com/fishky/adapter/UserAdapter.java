package com.fishky.adapter;

import com.fishky.dto.user.UserCreateDto;
import com.fishky.dto.user.UserDto;
import com.fishky.model.UserEntity;

import java.time.LocalDateTime;

public interface UserAdapter {
    UserEntity fromDto(UserCreateDto user);
    UserEntity fromDto(UserDto user, LocalDateTime creationTime);
    UserDto toDto(UserEntity user);
}
