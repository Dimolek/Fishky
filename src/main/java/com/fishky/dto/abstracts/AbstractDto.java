package com.fishky.dto.abstracts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public abstract class AbstractDto implements Serializable {

    @NotNull
    @NotEmpty
    private String id;
}
