package com.fishky.adapter;

import com.fishky.dto.translation.TranslationCreateDto;
import com.fishky.dto.translation.TranslationDto;
import com.fishky.dto.translation.TranslationsCreateDto;
import com.fishky.model.DictionaryEntity;
import com.fishky.model.TranslationEntity;

import java.util.List;

public interface TranslationAdapter {
    TranslationEntity fromDto(TranslationCreateDto translation, DictionaryEntity dictionary);
    List<TranslationEntity> fromDto(TranslationsCreateDto translations, DictionaryEntity dictionary);
    TranslationEntity fromDto(TranslationDto translation, DictionaryEntity dictionary);
    TranslationDto toDto(TranslationEntity translation);
}