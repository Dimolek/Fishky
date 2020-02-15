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
public final class IdDto {

    @NotNull
    @NotEmpty
    private Long id;

    public static IdDto of(final Long id) {
        return new IdDto(id);
    }
}
