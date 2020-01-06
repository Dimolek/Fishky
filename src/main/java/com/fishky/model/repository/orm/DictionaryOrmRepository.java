package com.fishky.model.repository.orm;

import com.fishky.model.DictionaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DictionaryOrmRepository extends JpaRepository<DictionaryEntity, Long> {

}
