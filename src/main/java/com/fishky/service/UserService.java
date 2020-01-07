package com.fishky.service;

import com.fishky.dto.abstracts.IdDto;
import com.fishky.dto.user.UserCreateDto;
import com.fishky.dto.user.UserDto;

public interface UserService {
    IdDto add(UserCreateDto user);
    UserDto read(IdDto id);
}
