package com.fishky.model.repository;

import com.fishky.model.DictionaryEntity;

public interface DictionaryRepository {
    Long save(DictionaryEntity dictionary);
    DictionaryEntity modify();
    Boolean delete();
    DictionaryEntity read(Long id);
}
