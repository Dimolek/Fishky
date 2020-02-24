package com.fishky.policy;

import com.fishky.policy.validation.annotations.Policy;
import com.fishky.repository.orm.TranslationOrmRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Policy
public final class TranslationPolicy {

    @Autowired
    private TranslationOrmRepository ormRepository;

    public void translationExists(final Long id) {
        if (!ormRepository.existsById(id))
            throw (new RuntimeException("Translation does not exist"));
    }
}
