package com.fishky.dto.user;

import com.fishky.policy.validation.annotations.PasswordMatches;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor
@Getter
@PasswordMatches
public final class UserCreateRequestDto {

    @NotNull
    @NotEmpty
    private final String username;

    @NotNull
    @NotEmpty
    private final String password;

    @NotNull
    @NotEmpty
    private final String confirmPassword;

    public static UserCreateRequestDto of(final String username, final String password, final String confirmPassword) {
        return new UserCreateRequestDto(username, password, confirmPassword);
    }
}
