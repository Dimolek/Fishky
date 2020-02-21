package com.fishky.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ApiStatusResponse {

    @NotNull
    @NotEmpty
    private final Integer status;

    @NotNull
    @NotEmpty
    private final String message;

    public static ApiStatusResponse of(final Integer status, final String message) {
        return new ApiStatusResponse(status, message);
    }
}
