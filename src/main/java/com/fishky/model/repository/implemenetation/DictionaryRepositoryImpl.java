package com.fishky.model.repository.implemenetation;

import com.fishky.model.DictionaryEntity;
import com.fishky.model.repository.orm.DictionaryOrmRepository;
import com.fishky.model.repository.DictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class DictionaryRepositoryImpl implements DictionaryRepository {

    @Autowired
    private DictionaryOrmRepository ormRepository;

    @Override
    public Integer save(DictionaryEntity dictionary) {
        return ormRepository.saveAndFlush(dictionary).getIdDictionary();
    }

    @Override
    public DictionaryEntity modify() {
        return null;
    }

    @Override
    public Boolean delete() {
        return null;
    }

    @Override
    public DictionaryEntity read() {
        return null;
    }
}
