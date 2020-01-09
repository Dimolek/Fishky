package com.fishky.dto.dictionary;

import com.fishky.dto.abstracts.AbstractDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
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

    protected DictionaryDto(final String id, final String name, final String language, final String userId) {
        super(id);
        this.name = name;
        this.language = language;
        this.userId = userId;
    }

    public static DictionaryDto of(final String id, final String name, final String language, final String userId) {
        return new DictionaryDto(id, name, language, userId);
    }
}
