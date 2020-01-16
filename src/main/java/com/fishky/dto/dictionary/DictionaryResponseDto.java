package com.fishky.dto.dictionary;

import com.fishky.dto.translation.TranslationDto;
import lombok.Getter;

import java.util.Set;

public final class DictionaryResponseDto extends DictionaryDto {

    @Getter
    private Set<TranslationDto> translations; //probably change to List<> to maintain some sort of order

    private DictionaryResponseDto(final Long id, final String name, final String language, final Long userId, final Set<TranslationDto> translations) {
        super(id, name, language, userId);
        this.translations = translations;
    }

    public static DictionaryResponseDto of(final Long id, final String name, final String language, final Long userId, final Set<TranslationDto> translations) {
        return new DictionaryResponseDto(id, name, language, userId, translations);
    }
}
