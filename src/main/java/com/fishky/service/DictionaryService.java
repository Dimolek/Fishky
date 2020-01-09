package com.fishky.service;


import com.fishky.dto.abstracts.IdDto;
import com.fishky.dto.dictionary.DictionaryCreateDto;
import com.fishky.dto.dictionary.DictionaryDto;
import com.fishky.dto.dictionary.DictionaryResponseDto;

public interface DictionaryService {
    IdDto add(DictionaryCreateDto dictionary);
    DictionaryResponseDto read(IdDto id);
    DictionaryDto modify(DictionaryDto dictionary);
    Boolean delete(IdDto id);
}
