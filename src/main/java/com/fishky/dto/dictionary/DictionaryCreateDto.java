package com.fishky.dto.dictionary;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor(force=true)
@AllArgsConstructor
@Getter
public class DictionaryCreateDto {

    @NotNull
    @NotEmpty
    private final String name;

    @NotNull
    @NotEmpty
    private final String language;

    @NotNull
    @NotEmpty
    private final Long userId;

    public static DictionaryCreateDto of(final String name, final String language, final Long userId) {
        return new DictionaryCreateDto(name, language, userId);
    }
}
