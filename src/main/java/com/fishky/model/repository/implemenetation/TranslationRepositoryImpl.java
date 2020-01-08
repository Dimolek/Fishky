package com.fishky.model.repository.implemenetation;

import com.fishky.model.TranslationEntity;
import com.fishky.model.repository.TranslationRepository;
import com.fishky.model.repository.orm.TranslationOrmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TranslationRepositoryImpl implements TranslationRepository {

    @Autowired
    private TranslationOrmRepository ormRepository;

    @Override
    public Integer save() {
        return null;
    }

    @Override
    public TranslationEntity modify() {
        return null;
    }

    @Override
    public Boolean delete() {
        return null;
    }

    @Override
    public TranslationEntity read() {
        return null;
    }
}
