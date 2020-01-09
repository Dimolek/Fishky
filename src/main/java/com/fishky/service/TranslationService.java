package com.fishky.service;

import com.fishky.dto.abstracts.IdDto;
import com.fishky.dto.translation.TranslationCreateDto;
import com.fishky.dto.translation.TranslationDto;
import com.fishky.dto.translation.TranslationsCreateDto;

import java.util.List;

public interface TranslationService {
    IdDto add(TranslationCreateDto translation);
    List<IdDto> addMany(TranslationsCreateDto translations);
    TranslationDto read(IdDto id);
    TranslationDto modify(TranslationDto translation);
    Boolean delete(IdDto id);
}
