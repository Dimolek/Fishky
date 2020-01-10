package com.fishky.service;


import com.fishky.dto.abstracts.IdDto;
import com.fishky.dto.dictionary.DictionaryCreateDto;
import com.fishky.dto.dictionary.DictionaryDto;
import com.fishky.dto.dictionary.DictionaryResponseDto;

import java.util.List;

public interface DictionaryService {
    IdDto add(DictionaryCreateDto dictionary);
    DictionaryResponseDto read(IdDto id);
    List<DictionaryDto> readUsersDictionaries(IdDto userId);
    DictionaryDto modify(DictionaryDto dictionary);
    Boolean delete(IdDto id);
}
