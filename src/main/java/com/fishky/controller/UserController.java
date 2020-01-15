package com.fishky.controller;

import com.fishky.dto.abstracts.IdDto;
import com.fishky.dto.user.UserCreateDto;
import com.fishky.dto.user.UserDto;
import com.fishky.properties.ConstURLMapping;
import com.fishky.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping(value = ConstURLMapping.ADD_USER)
    public IdDto add(@RequestBody final UserCreateDto user) {
        return service.add(user);
    }

    @GetMapping(value = ConstURLMapping.FIND_USER)
    public UserDto find(@RequestParam(value = ConstURLMapping.ENTITY_ID) final String id) {
        return service.read(IdDto.of(Long.valueOf(id)));
    }

    @PutMapping(value = ConstURLMapping.MODIFY_USER)
    public UserDto modify(@RequestBody final UserDto user) {
        return service.modify(user);
    }

    @DeleteMapping(value = ConstURLMapping.DELETE_USER)
    public Boolean delete(@RequestBody final IdDto id) {
        return service.delete(id);
    }
}
