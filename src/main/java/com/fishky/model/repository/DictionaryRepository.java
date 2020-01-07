package com.fishky.model.repository;

import com.fishky.model.DictionaryEntity;

public interface DictionaryRepository {
    Integer save();
    DictionaryEntity modify();
    Boolean delete();
    DictionaryEntity read();
}
