package com.fishky.service.implementation;

import com.fishky.adapter.UserAdapter;
import com.fishky.dto.abstracts.IdDto;
import com.fishky.dto.user.UserCreateDto;
import com.fishky.dto.user.UserDto;
import com.fishky.model.repository.UserRepository;
import com.fishky.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserAdapter adapter;

    @Autowired
    private UserRepository userRepository;

    @Override
    public IdDto add(final UserCreateDto user) {
        return IdDto.of(
                String.valueOf(
                        userRepository.save(
                                adapter.fromDto(user))));
    }

    @Override
    public UserDto read(final IdDto id) {
        return adapter.toDto(
                userRepository.read(
                        Long.valueOf(id.getId())));
    }

    @Override
    public UserDto modify(UserDto user) {
        return adapter.toDto(
                userRepository.modify(
                        adapter.fromDto(user,
                                userRepository.read(Long.valueOf(user.getId())).getCreateTime().toLocalDateTime())));
    }

    @Override
    public Boolean delete(IdDto id) {
        //Also, delete all dependent dictionaries
        return userRepository.delete(Long.valueOf(id.getId()));
    }

}
