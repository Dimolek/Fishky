package com.fishky.dto.translation;

import com.fishky.dto.abstracts.AbstractDto;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
public class TranslationDto extends AbstractDto {

    @NotNull
    @NotEmpty
    private final String word;

    @NotNull
    @NotEmpty
    private final String translated;

    @NotNull
    @NotEmpty
    private final String dictionaryId;

    private TranslationDto(final String id, final String word, final String translated, final String dictionaryId) {
        super(id);
        this.word = word;
        this.translated = translated;
        this.dictionaryId = dictionaryId;
    }

    public static TranslationDto of(final String id, final String word, final String translated, final String dictionaryId) {
        return new TranslationDto(id, word, translated, dictionaryId);
    }
}
