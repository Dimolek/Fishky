package com.fishky.model.repository.implemenetation;

import com.fishky.model.repository.orm.DictionaryListOrmRepository;
import com.fishky.model.repository.DictionaryListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DictionaryListRepositoryImpl implements DictionaryListRepository {
    @Autowired
    private DictionaryListOrmRepository ormRepository;
}
