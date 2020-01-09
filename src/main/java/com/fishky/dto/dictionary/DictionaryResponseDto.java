package com.fishky.dto.dictionary;

import com.fishky.dto.translation.TranslationDto;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

public class DictionaryResponseDto extends DictionaryDto {

    @NotNull
    @NotEmpty
    @Getter
    Set<TranslationDto> translations; //probably change to List<> to maintain some sort of order

    private DictionaryResponseDto(final String id, final String name, final String language, final String userId, final Set<TranslationDto> translations) {
        super(id, name, language, userId);
        this.translations = translations;
    }

    public static DictionaryResponseDto of(final String id, final String name, final String language, final String userId, final Set<TranslationDto> translations) {
        return new DictionaryResponseDto(id, name, language, userId, translations);
    }
}
