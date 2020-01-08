package com.fishky.adapter;

import com.fishky.dto.dictionary.DictionaryCreateDto;
import com.fishky.dto.dictionary.DictionaryDto;
import com.fishky.model.DictionaryEntity;
import com.fishky.model.UserEntity;

public interface DictionaryAdapter {
    DictionaryEntity fromDto(DictionaryCreateDto dictionary, UserEntity user);
    DictionaryDto toDto(DictionaryEntity dictionary);
}
