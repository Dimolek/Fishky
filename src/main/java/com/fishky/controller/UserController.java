package com.fishky.controller;

import com.fishky.dto.IdDto;
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
    private static final String ADD_USER = "/addUser";
    private static final String FIND_USER = "/findUserById";
    private static final String MODIFY_USER = "/modifyUser";
    private static final String DELETE_USER = "/deleteUserById";

    @Autowired
    private UserService service;

    @PostMapping(value = ADD_USER)
    public IdDto add(@RequestBody @Valid final UserCreateRequestDto user) {
        return service.add(user);
    }

    @GetMapping(value = FIND_USER)
    public UserDto find(@RequestParam(value = ENTITY_ID) final String id) {
        return service.read(IdDto.of(Long.valueOf(id)));
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
