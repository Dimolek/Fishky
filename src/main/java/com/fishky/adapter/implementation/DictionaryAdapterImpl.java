package com.fishky.adapter.implementation;

import com.fishky.adapter.DictionaryAdapter;
import com.fishky.dto.dictionary.DictionaryCreateDto;
import com.fishky.dto.dictionary.DictionaryDto;
import com.fishky.model.DictionaryEntity;
import com.fishky.model.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class DictionaryAdapterImpl implements DictionaryAdapter {

    @Override
    public DictionaryEntity fromDto(DictionaryCreateDto dictionary, UserEntity user) {
        return new DictionaryEntity(
                dictionary.getName(),
                dictionary.getLanguage(),
                user);
    }

    @Override
    public DictionaryDto toDto(DictionaryEntity dictionary) {
        return DictionaryDto.of(
                String.valueOf(dictionary.getIdDictionary()),
                dictionary.getName(),
                dictionary.getLanguage(),
                String.valueOf(dictionary.getUser().getIdUser()));
    }
}
