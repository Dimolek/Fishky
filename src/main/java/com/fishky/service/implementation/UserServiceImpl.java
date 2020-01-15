package com.fishky.service.implementation;

import com.fishky.dto.abstracts.IdDto;
import com.fishky.dto.user.UserCreateDto;
import com.fishky.dto.user.UserDto;
import com.fishky.mapper.UserMapper;
import com.fishky.repository.UserRepository;
import com.fishky.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    public IdDto add(final UserCreateDto user) {
        return IdDto.of(userRepository.save(
                                mapper.fromDto(user)));
    }

    @Override
    public UserDto read(final IdDto id) {
        return mapper.toDto(
                userRepository.read(id.getId()));
    }

    @Override
    public UserDto modify(UserDto user) {
        return mapper.toDto(
                userRepository.modify(
                        mapper.fromDto(user,
                                userRepository.read(user.getId()).getCreateTime().toLocalDateTime())));
    }

    @Override
    public Boolean delete(IdDto id) {
        //Also, delete all dependent dictionaries
        return userRepository.delete(id.getId());
    }

}
