package com.fishky.dto.user;

import com.fishky.dto.abstracts.AbstractDto;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
public class UserDto extends AbstractDto {

    @NotNull
    @NotEmpty
    private final String username;

    @NotNull
    @NotEmpty
    private final String password;

    private UserDto(final String id, final String username, final String password) {
        super(id);
        this.username = username;
        this.password = password;
    }

    public static UserDto of(final String id, final String username, final String password) {
        return new UserDto(id, username, password);
    }
}
