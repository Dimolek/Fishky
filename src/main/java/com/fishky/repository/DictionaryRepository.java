package com.fishky.repository;

import com.fishky.model.DictionaryEntity;

import java.util.List;

public interface DictionaryRepository {
    DictionaryEntity save(DictionaryEntity dictionary);
    DictionaryEntity read(Long id);
    List<DictionaryEntity> readUsersDictionaries(String userName);
    DictionaryEntity modify(DictionaryEntity dictionary);
    Boolean delete(Long id);

}
