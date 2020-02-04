package com.fishky.repository.implemenetation;

import com.fishky.model.DictionaryEntity;
import com.fishky.repository.DictionaryRepository;
import com.fishky.repository.orm.DictionaryOrmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class DictionaryRepositoryImpl implements DictionaryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private DictionaryOrmRepository ormRepository;

    @Override
    public Long save(final DictionaryEntity dictionary) {
        return ormRepository.saveAndFlush(dictionary).getIdDictionary();
    }

    @Override
    public DictionaryEntity read(final Long id) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<DictionaryEntity> query = cb.createQuery(DictionaryEntity.class);
        Root<DictionaryEntity> dictionary = query.from(DictionaryEntity.class);
        dictionary.fetch("translations");
        query.select(dictionary).where(cb.equal(dictionary.get("idDictionary"), id));
        TypedQuery<DictionaryEntity> typedQuery = entityManager.createQuery(query);
        return typedQuery.getSingleResult();
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
