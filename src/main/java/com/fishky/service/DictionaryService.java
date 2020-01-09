package com.fishky.service;


import com.fishky.dto.abstracts.IdDto;
import com.fishky.dto.dictionary.DictionaryCreateDto;
import com.fishky.dto.dictionary.DictionaryDto;

public interface DictionaryService {
    IdDto add(DictionaryCreateDto dictionary);
    DictionaryDto read(IdDto id);
}
