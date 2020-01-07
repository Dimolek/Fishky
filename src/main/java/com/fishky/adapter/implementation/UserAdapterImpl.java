package com.fishky.adapter.implementation;

import com.fishky.adapter.UserAdapter;
import com.fishky.dto.abstracts.IdDto;
import com.fishky.dto.user.UserCreateDto;
import com.fishky.dto.user.UserDto;
import com.fishky.model.UserEntity;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Component
public class UserAdapterImpl implements UserAdapter {

    @Override
    public UserEntity fromDto(UserCreateDto user) {
        return new UserEntity(
                user.getUsername(),
                user.getPassword(),
                Timestamp.valueOf(LocalDateTime.now()));
    }

    @Override
    public UserDto toDto(UserEntity user) {
        return UserDto.of(
                String.valueOf(
                        user.getIdUser()),
                user.getUsername(),
                user.getPassword());
    }
}
