package com.fishky.service;

import com.fishky.dto.IdDto;
import com.fishky.dto.user.UserCreateRequestDto;
import com.fishky.dto.user.UserDto;
import com.fishky.mapper.UserMapper;
import com.fishky.model.UserEntity;
import com.fishky.policy.UserPolicy;
import com.fishky.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserPolicy userPolicy;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public IdDto add(final UserCreateRequestDto user) {
        userPolicy.userExists(user.getUsername());
        UserEntity userEntity = UserMapper.fromDto(user);
        userEntity.setPassword(bCryptPasswordEncoder.encode(userEntity.getPassword()));
        return IdDto.of(userRepository.save(userEntity));
    }

    public UserDto read(final IdDto id) {
        return UserMapper.toDto(
                userRepository.readById(id.getId())
        );
    }

    public UserDto modify(final UserDto user) {
        return UserMapper.toDto(
                userRepository.modify(
                        UserMapper.fromDto(user,
                                userRepository.readById(user.getId()).getCreateTime().toLocalDateTime()
                        )
                )
        );
    }

    public Boolean delete(final IdDto id) {
        //Also, delete all dependent dictionaries
        return userRepository.delete(id.getId());
    }

}
