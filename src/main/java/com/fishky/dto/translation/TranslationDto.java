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
    private final Long dictionaryId;

    private TranslationDto(final Long id, final String word, final String translated, final Long dictionaryId) {
        super(id);
        this.word = word;
        this.translated = translated;
        this.dictionaryId = dictionaryId;
    }

    public static TranslationDto of(final Long id, final String word, final String translated, final Long dictionaryId) {
        return new TranslationDto(id, word, translated, dictionaryId);
    }
}
