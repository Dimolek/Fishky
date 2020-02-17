package com.fishky.dto.dictionary;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class DictionaryDto {

    @NotNull
    @NotEmpty
    private Long id;

    @NotNull
    @NotEmpty
    private final String name;

    @NotNull
    @NotEmpty
    private final String language;

    public static DictionaryDto of(final Long id, final String name, final String language) {
        return new DictionaryDto(id, name, language);
    }
}
