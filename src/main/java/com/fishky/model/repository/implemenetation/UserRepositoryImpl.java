package com.fishky.model.repository.implemenetation;

import com.fishky.model.UserEntity;
import com.fishky.model.repository.orm.UserOrmRepository;
import com.fishky.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private UserOrmRepository ormRepository;

    @Override
    public Long save(final UserEntity user) {
        // Always returns 0
        // TODO: make sessions
        return ormRepository.saveAndFlush(user).getIdUser();
    }

    @Override
    public UserEntity modify(UserEntity user) {
        return null;
    }

    @Override
    public Boolean delete() {
        return null;
    }

    @Override
    public UserEntity read(Long id) {
        return ormRepository.findById(id).orElse(null);
    }
}
