package com.fishky.model.repository;

import com.fishky.model.UserEntity;

public interface UserRepository {
    Long save(UserEntity user);
    UserEntity modify(UserEntity user);
    Boolean delete();
    UserEntity read(Long id);
}
