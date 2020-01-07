package com.fishky.model.repository;

import com.fishky.model.UserEntity;

public interface UserRepository {
    Long save(UserEntity user);
    UserEntity modify();
    Boolean delete();
    UserEntity read(Long id);
}
