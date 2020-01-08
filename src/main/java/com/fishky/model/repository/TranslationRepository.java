package com.fishky.model.repository;

import com.fishky.model.TranslationEntity;

public interface TranslationRepository {
    Integer save();
    TranslationEntity modify();
    Boolean delete();
    TranslationEntity read();
}
