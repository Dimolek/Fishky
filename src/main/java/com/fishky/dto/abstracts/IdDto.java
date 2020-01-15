package com.fishky.dto.abstracts;

import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@Getter
@NoArgsConstructor(access = PRIVATE)
public class IdDto extends AbstractDto {

    private IdDto(final Long id) {
        super(id);
    }

    public static IdDto of(final Long id) {
        return new IdDto(id);
    }
}
