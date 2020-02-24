package com.fishky.service;

import com.fishky.dto.IdDto;
import com.fishky.dto.NameDto;
import com.fishky.dto.user.UserCreateRequestDto;
import com.fishky.dto.user.UserDto;
import com.fishky.mapper.UserMapper;
import com.fishky.model.UserEntity;
import com.fishky.policy.UserPolicy;
import com.fishky.repository.UserRepository;
import com.fishky.security.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

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
        userPolicy.userAlreadyExists(user.getUsername());
        UserEntity userEntity = UserMapper.fromDto(user);
        userEntity.setPassword(bCryptPasswordEncoder.encode(userEntity.getPassword()));
        return IdDto.of(userRepository.save(userEntity));
    }

    public UserDto readById(final IdDto id) {

        return UserMapper.toDto(
                userRepository.readById(id.getId())
        );
    }

    public IdDto readByUsername(final NameDto username) {
        userPolicy.userExists(username.getName());
        return UserMapper.toDto(
                userRepository.readIdByUsername(username.getName())
        );
    }

    public UserDto modify(final UserDto user) {
        userPolicy.userExists(user.getUsername());
        return UserMapper.toDto(
                userRepository.modify(
                        UserMapper.fromDto(user,
                                userRepository.readByUsername(user.getUsername()).getCreateTime().toLocalDateTime()
                        )
                )
        );
    }

    public Boolean delete(final IdDto id) {
        //Also, delete all dependent dictionaries
        userPolicy.userExists(id.getId());
        return userRepository.delete(id.getId());
    }

    public ResponseEntity<String> checkAuthentication(HttpServletRequest request) {
        return userPolicy.checkAuthentication(AuthenticationService.getAuthentication(request));
    }

}
