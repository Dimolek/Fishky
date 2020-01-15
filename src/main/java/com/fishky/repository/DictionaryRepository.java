package com.fishky.repository;

import com.fishky.model.DictionaryEntity;

import java.util.List;

public interface DictionaryRepository {
    Long save(DictionaryEntity dictionary);
    DictionaryEntity read(Long id);
    List<DictionaryEntity> readUsersDictionaries(Long userId);
    DictionaryEntity modify(DictionaryEntity dictionary);
    Boolean delete(Long id);

}
