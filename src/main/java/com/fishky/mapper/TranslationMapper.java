package com.fishky.mapper;

import com.fishky.dto.translation.TranslationCreateRequestDto;
import com.fishky.dto.translation.TranslationDto;
import com.fishky.dto.translation.TranslationsCreateRequestDto;
import com.fishky.model.DictionaryEntity;
import com.fishky.model.TranslationEntity;

import java.util.List;
import java.util.stream.Collectors;

public class TranslationMapper {
    public static TranslationEntity fromDto(final TranslationCreateRequestDto translation, final DictionaryEntity dictionary) {
        return new TranslationEntity(
                translation.getWord(),
                translation.getTranslated(),
                dictionary);
    }

    public static List<TranslationEntity> fromDto(final TranslationsCreateRequestDto translations, final DictionaryEntity dictionary) {
        return translations.getTranslations()
                .stream()
                .map(tcd -> fromDto(tcd, dictionary))
                .collect(Collectors.toList());
    }

    public static TranslationEntity fromDto(final TranslationDto translation, final DictionaryEntity dictionary) {
        return new TranslationEntity(
                translation.getId(),
                translation.getWord(),
                translation.getTranslated(),
                dictionary);
    }

    public static TranslationDto toDto(final TranslationEntity translation) {
        return TranslationDto.of(
                translation.getIdTranslation(),
                translation.getWord(),
                translation.getTranslated(),
                translation.getDictionary().getIdDictionary());
    }
}
