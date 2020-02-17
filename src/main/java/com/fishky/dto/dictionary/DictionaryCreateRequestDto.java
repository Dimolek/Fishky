package com.fishky.dto.dictionary;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor(force=true)
@AllArgsConstructor
@Getter
public final class DictionaryCreateRequestDto {

    @NotNull
    @NotEmpty
    private final String name;

    @NotNull
    @NotEmpty
    private final String language;

    public static DictionaryCreateRequestDto of(final String name, final String language) {
        return new DictionaryCreateRequestDto(name, language);
    }
}
