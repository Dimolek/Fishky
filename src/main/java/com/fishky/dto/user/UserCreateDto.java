package com.fishky.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor(force=true)
@AllArgsConstructor
@Getter
public class UserCreateDto {

    @NotNull
    @NotEmpty
    private final String username;

    @NotNull
    @NotEmpty
    private final String password;

    public static UserCreateDto of(final String username, final String password) {
        return new UserCreateDto(username, password);
    }
}
