package com.fishky.service;

import com.fishky.dto.IdDto;
import com.fishky.dto.user.UserCreateRequestDto;
import com.fishky.dto.user.UserDto;
import com.fishky.mapper.UserMapper;
import com.fishky.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public IdDto add(final UserCreateRequestDto user) {
        return IdDto.of(userRepository.save(
                                UserMapper.fromDto(user)));
    }

    public UserDto read(final IdDto id) {
        return UserMapper.toDto(
                userRepository.read(id.getId()));
    }

    public UserDto modify(UserDto user) {
        return UserMapper.toDto(
                userRepository.modify(
                        UserMapper.fromDto(user,
                                userRepository.read(user.getId()).getCreateTime().toLocalDateTime())));
    }

    public Boolean delete(IdDto id) {
        //Also, delete all dependent dictionaries
        return userRepository.delete(id.getId());
    }

}
