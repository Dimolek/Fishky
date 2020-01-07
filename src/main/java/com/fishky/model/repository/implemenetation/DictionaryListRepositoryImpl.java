package com.fishky.model.repository.implemenetation;

import com.fishky.model.DictionaryListEntity;
import com.fishky.model.repository.orm.DictionaryListOrmRepository;
import com.fishky.model.repository.DictionaryListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DictionaryListRepositoryImpl implements DictionaryListRepository {
    @Autowired
    private DictionaryListOrmRepository ormRepository;

    @Override
    public Integer save() {
        return null;
    }

    @Override
    public DictionaryListEntity modify() {
        return null;
    }

    @Override
    public Boolean delete() {
        return null;
    }

    @Override
    public DictionaryListEntity read() {
        return null;
    }
}
