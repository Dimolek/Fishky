package com.fishky.repository.orm;

import com.fishky.model.TranslationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TranslationOrmRepository extends JpaRepository<TranslationEntity, Long> {
}
