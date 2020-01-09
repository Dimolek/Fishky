package com.fishky.dto.translation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor(force=true)
@AllArgsConstructor
@Getter
public class TranslationsCreateDto {

    @NotNull
    @NotEmpty
    List<TranslationCreateDto> translations;

    @NotNull
    @NotEmpty
    private final String dictionaryId;

    public static TranslationsCreateDto of(final List<TranslationCreateDto> translations, final String dictionaryId) {
        return new TranslationsCreateDto(translations, dictionaryId);
    }
}
