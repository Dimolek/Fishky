package com.fishky.controller;

import com.fishky.dto.IdDto;
import com.fishky.dto.NameDto;
import com.fishky.dto.user.UserCreateRequestDto;
import com.fishky.dto.user.UserDto;
import com.fishky.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private static final String ENTITY_ID = "id";
    private static final String USERNAME = "username";
    private static final String ADD_USER = "/addUser";
    private static final String FIND_USER_BY_ID = "/findUserById";
    private static final String FIND_USER_BY_USERNAME = "/findUserByUsername";
    private static final String MODIFY_USER = "/modifyUser";
    private static final String DELETE_USER = "/deleteUserById";


    @Autowired
    private UserService service;

    @PostMapping(value = ADD_USER)
    public IdDto add(@RequestBody @Valid final UserCreateRequestDto user) {
        return service.add(user);
    }

    @GetMapping(value = FIND_USER_BY_ID)
    public UserDto findById(@RequestParam(value = ENTITY_ID) final String id) {
        return service.readById(IdDto.of(Long.valueOf(id)));
    }

    @GetMapping(value = FIND_USER_BY_USERNAME)
    public IdDto findByUsername(@RequestParam(value = USERNAME) final String username) {
        return service.readByUsername(NameDto.of(username));
    }

    @PutMapping(value = MODIFY_USER)
    public UserDto modify(@RequestBody final UserDto user) {
        return service.modify(user);
    }

    @DeleteMapping(value = DELETE_USER)
    public Boolean delete(@RequestBody final IdDto id) {
        return service.delete(id);
    }
}
