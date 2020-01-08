package com.fishky.dto.dictionary;

import com.fishky.dto.abstracts.AbstractDto;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
public class DictionaryDto extends AbstractDto {

    @NotNull
    @NotEmpty
    private final String name;

    @NotNull
    @NotEmpty
    private final String language;

    @NotNull
    @NotEmpty
    private final String userId;

    public DictionaryDto(final String id, final String name, final String language, final String userId) {
        super(id);
        this.name = name;
        this.language = language;
        this.userId = userId;
    }

    public static DictionaryDto of(final String id, final String name, final String language, final String userId) {
        return new DictionaryDto(id, name, language, userId);
    }
}
