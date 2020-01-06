package com.fishky.model.repository.orm;

import com.fishky.model.DictionaryListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DictionaryListOrmRepository extends JpaRepository<DictionaryListEntity, Long> {
}
