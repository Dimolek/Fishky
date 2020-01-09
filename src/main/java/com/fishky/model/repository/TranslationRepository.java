package com.fishky.model.repository;

import com.fishky.model.TranslationEntity;

import java.util.List;

public interface TranslationRepository {
    Long save(TranslationEntity translation);
    List<Long> saveMany(List<TranslationEntity> translations);
    TranslationEntity read();
    TranslationEntity modify();
    Boolean delete();

}
