package com.fishky.model.repository.implemenetation;

import com.fishky.model.repository.orm.UserOrmRepository;
import com.fishky.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private UserOrmRepository ormRepository;
}
