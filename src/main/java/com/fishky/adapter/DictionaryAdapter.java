package com.fishky.adapter;

import com.fishky.dto.dictionary.DictionaryCreateDto;
import com.fishky.dto.dictionary.DictionaryDto;
import com.fishky.dto.dictionary.DictionaryResponseDto;
import com.fishky.model.DictionaryEntity;
import com.fishky.model.UserEntity;

import java.util.List;

public interface DictionaryAdapter {
    DictionaryEntity fromDto(DictionaryCreateDto dictionary, UserEntity user);
    DictionaryEntity fromDto(DictionaryDto dictionary, UserEntity user);
    DictionaryResponseDto toDto(DictionaryEntity dictionary);
    List<DictionaryDto> toDto(List<DictionaryEntity> dictionaries);
}
