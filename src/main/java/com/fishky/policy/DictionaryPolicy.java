package com.fishky.policy;

import com.fishky.policy.validation.annotations.Policy;
import com.fishky.repository.orm.DictionaryOrmRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Policy
public final class DictionaryPolicy {

    @Autowired
    private DictionaryOrmRepository ormRepository;

    public void dictionaryExists(final Long id) {
        if (!ormRepository.existsById(id))
            throw (new RuntimeException("Dictionary does not exist"));
    }
}
