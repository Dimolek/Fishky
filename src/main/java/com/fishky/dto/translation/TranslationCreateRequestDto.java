package com.fishky.dto.translation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor(force=true)
@AllArgsConstructor
@Getter
public final class TranslationCreateRequestDto {

    @NotNull
    @NotEmpty
    private final String word;

    @NotNull
    @NotEmpty
    private final String translated;

    @NotNull
    @NotEmpty
    private final Long dictionaryId;

    public static TranslationCreateRequestDto of(final String word, final String translated, final Long dictionaryId) {
        return new TranslationCreateRequestDto(word, translated, dictionaryId);
    }
}
