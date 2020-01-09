package com.fishky.model.repository;

import com.fishky.model.DictionaryEntity;

public interface DictionaryRepository {
    Long save(DictionaryEntity dictionary);
    DictionaryEntity read(Long id);
    DictionaryEntity modify(DictionaryEntity dictionary);
    Boolean delete(Long id);

}
