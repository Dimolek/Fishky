package com.fishky.dto.abstracts;

import lombok.Getter;

public class IdDto extends AbstractDto {

    private IdDto(final String id) {
        super(id);
    }

    public static IdDto of(final String id) {
        return new IdDto(id);
    }
}
