package com.fishky.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import static lombok.AccessLevel.PRIVATE;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = PRIVATE)
public final class NameDto {

    @NotNull
    @NotEmpty
    private String name;

    public static NameDto of(final String name) {
        return new NameDto(name);
    }
}
