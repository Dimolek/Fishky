package com.fishky.mapper.implementation;

import com.fishky.dto.dictionary.DictionaryCreateDto;
import com.fishky.dto.dictionary.DictionaryDto;
import com.fishky.dto.dictionary.DictionaryResponseDto;
import com.fishky.mapper.DictionaryMapper;
import com.fishky.mapper.TranslationMapper;
import com.fishky.model.DictionaryEntity;
import com.fishky.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DictionaryMapperImpl implements DictionaryMapper {

    @Autowired
    TranslationMapper translationMapper;

    @Override
    public DictionaryEntity fromDto(final DictionaryCreateDto dictionary, final UserEntity user) {
        return new DictionaryEntity(
                dictionary.getName(),
                dictionary.getLanguage(),
                user);
    }

    @Override
    public DictionaryEntity fromDto(final DictionaryDto dictionary, final UserEntity user) {
        return new DictionaryEntity(
                dictionary.getId(),
                dictionary.getName(),
                dictionary.getLanguage(),
                user);
    }

    @Override
    public DictionaryResponseDto toDto(final DictionaryEntity dictionary) {
        return DictionaryResponseDto.of(
                dictionary.getIdDictionary(),
                dictionary.getName(),
                dictionary.getLanguage(),
                dictionary.getUser().getIdUser(),
                dictionary.getTranslations()
                        .stream()
                        .map(translationEntity -> translationMapper.toDto(translationEntity))
                        .collect(Collectors.toSet()));
    }

    @Override
    public List<DictionaryDto> toDto(List<DictionaryEntity> dictionaries) {
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
