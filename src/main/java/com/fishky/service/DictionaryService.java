package com.fishky.service;


import com.fishky.dto.abstracts.IdDto;
import com.fishky.dto.dictionary.DictionaryCreateDto;

public interface DictionaryService {
    IdDto add(DictionaryCreateDto dictionary);
}
