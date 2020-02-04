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
public final class TranslationsCreateRequestDto {

    @NotNull
    @NotEmpty
    List<TranslationCreateRequestDto> translations;

    @NotNull
    @NotEmpty
    private final Long dictionaryId;

    public static TranslationsCreateRequestDto of(final List<TranslationCreateRequestDto> translations, final Long dictionaryId) {
        return new TranslationsCreateRequestDto(translations, dictionaryId);
    }
}
