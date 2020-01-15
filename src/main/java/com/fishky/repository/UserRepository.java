package com.fishky.repository;

import com.fishky.model.UserEntity;

public interface UserRepository {
    Long save(UserEntity user);
    UserEntity read(Long id);
    UserEntity modify(UserEntity user);
    Boolean delete(Long id);
}
