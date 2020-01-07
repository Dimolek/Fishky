package com.fishky.model.repository;

import com.fishky.model.DictionaryListEntity;

public interface DictionaryListRepository {
    Integer save();
    DictionaryListEntity modify();
    Boolean delete();
    DictionaryListEntity read();
}
