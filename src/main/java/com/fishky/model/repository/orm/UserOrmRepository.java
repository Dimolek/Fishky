package com.fishky.model.repository.orm;

import com.fishky.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserOrmRepository extends JpaRepository<UserEntity, Long> {
}
