package com.fishky.dto.translation;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public final class TranslationDto {

    @NotNull
    @NotEmpty
    private Long id;

    @NotNull
    @NotEmpty
    private final String word;

    @NotNull
    @NotEmpty
    private final String translated;

    @NotNull
    @NotEmpty
    private final Long dictionaryId;

    public static TranslationDto of(final Long id, final String word, final String translated, final Long dictionaryId) {
        return new TranslationDto(id, word, translated, dictionaryId);
    }
}
