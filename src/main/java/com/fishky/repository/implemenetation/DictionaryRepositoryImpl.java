package com.fishky.repository.implemenetation;

import com.fishky.model.DictionaryEntity;
import com.fishky.repository.DictionaryRepository;
import com.fishky.repository.orm.DictionaryOrmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DictionaryRepositoryImpl implements DictionaryRepository {

    @Autowired
    private DictionaryOrmRepository ormRepository;

    @Override
    public Long save(final DictionaryEntity dictionary) {
        return ormRepository.saveAndFlush(dictionary).getIdDictionary();
    }

    @Override
    public DictionaryEntity read(final Long id) {
        return ormRepository.findById(id).orElse(null);
    }

    @Override
    public List<DictionaryEntity> readUsersDictionaries(Long userId) {
        return ormRepository.findByUser_IdUser(userId);
    }

    @Override
    public DictionaryEntity modify(final DictionaryEntity dictionary) {
        //Possible 'exists' validation
        return ormRepository.saveAndFlush(dictionary);
    }

    @Override
    public Boolean delete(final Long id) {
        //Possible 'exists' validation
        //Also, delete all dependent translations (or in service)
        ormRepository.deleteById(id);
        return !ormRepository.existsById(id);
    }

}
