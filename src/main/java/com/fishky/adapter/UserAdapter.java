package com.fishky.adapter;

import com.fishky.dto.user.UserCreateDto;
import com.fishky.dto.user.UserDto;
import com.fishky.model.UserEntity;

public interface UserAdapter {
    UserEntity fromDto(UserCreateDto user);
    UserDto toDto(UserEntity user);
}
