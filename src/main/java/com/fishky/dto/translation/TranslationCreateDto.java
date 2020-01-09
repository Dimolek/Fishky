package com.fishky.dto.translation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor(force=true)
@AllArgsConstructor
@Getter
public class TranslationCreateDto {

    @NotNull
    @NotEmpty
    private final String word;

    @NotNull
    @NotEmpty
    private final String translated;

    @NotNull
    @NotEmpty
    private final String dictionaryId;

    public static TranslationCreateDto of(final String word, final String translated, final String dictionaryId) {
        return new TranslationCreateDto(word, translated, dictionaryId);
    }
}
