package com.fishky.repository.orm;

import com.fishky.model.DictionaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DictionaryOrmRepository extends JpaRepository<DictionaryEntity, Long> {
    List<DictionaryEntity> findByUser_Username(String username);
}
