package com.fishky.adapter.implementation;

import com.fishky.adapter.DictionaryAdapter;
import com.fishky.adapter.TranslationAdapter;
import com.fishky.dto.dictionary.DictionaryCreateDto;
import com.fishky.dto.dictionary.DictionaryDto;
import com.fishky.dto.dictionary.DictionaryResponseDto;
import com.fishky.model.DictionaryEntity;
import com.fishky.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DictionaryAdapterImpl implements DictionaryAdapter {

    @Autowired
    TranslationAdapter translationAdapter;

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
                Long.parseLong(dictionary.getId()),
                dictionary.getName(),
                dictionary.getLanguage(),
                user);
    }

    @Override
    public DictionaryResponseDto toDto(final DictionaryEntity dictionary) {
        return DictionaryResponseDto.of(
                String.valueOf(dictionary.getIdDictionary()),
                dictionary.getName(),
                dictionary.getLanguage(),
                String.valueOf(dictionary.getUser().getIdUser()),
                dictionary.getTranslations()
                        .stream()
                        .map(translationEntity -> translationAdapter.toDto(translationEntity))
                        .collect(Collectors.toSet()));
    }

    @Override
    public List<DictionaryDto> toDto(List<DictionaryEntity> dictionaries) {
        return dictionaries
                .stream()
                .map(entity -> DictionaryDto.of(
                        String.valueOf(entity.getIdDictionary()),
                        entity.getName(),
                        entity.getLanguage(),
                        String.valueOf(entity.getUser().getIdUser())))
                .collect(Collectors.toList());
    }
}
