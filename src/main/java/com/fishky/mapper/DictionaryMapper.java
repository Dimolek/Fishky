package com.fishky.mapper;

import com.fishky.dto.dictionary.DictionaryCreateRequestDto;
import com.fishky.dto.dictionary.DictionaryDto;
import com.fishky.dto.dictionary.DictionaryResponseDto;
import com.fishky.model.DictionaryEntity;
import com.fishky.model.UserEntity;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DictionaryMapper {

    public static DictionaryEntity fromDto(final DictionaryCreateRequestDto dictionary, final UserEntity user) {
        return new DictionaryEntity(
                dictionary.getName(),
                dictionary.getLanguage(),
                user);
    }

    public static DictionaryEntity fromDto(final DictionaryDto dictionary, final UserEntity user) {
        return new DictionaryEntity(
                dictionary.getId(),
                dictionary.getName(),
                dictionary.getLanguage(),
                user);
    }

    @SuppressWarnings("unchecked")
    public static DictionaryResponseDto toDto(final DictionaryEntity dictionary) {
        return DictionaryResponseDto.of(
                dictionary.getIdDictionary(),
                dictionary.getName(),
                dictionary.getLanguage(),
                dictionary.getUser().getIdUser(),
                Optional.ofNullable(dictionary.getTranslations())
                        .map(translationEntities -> translationEntities
                                .stream()
                                .map(TranslationMapper::toDto)
                                .collect(Collectors.toSet()))
                        .orElse(Collections.EMPTY_SET));
    }

    public static List<DictionaryDto> toDto(List<DictionaryEntity> dictionaries) {
        return dictionaries
                .stream()
                .map(entity -> DictionaryDto.of(
                        entity.getIdDictionary(),
                        entity.getName(),
                        entity.getLanguage(),
                        entity.getUser().getIdUser()))
                .collect(Collectors.toList());
    }
}
