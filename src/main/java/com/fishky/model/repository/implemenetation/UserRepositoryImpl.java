package com.fishky.model.repository.implemenetation;

import com.fishky.model.UserEntity;
import com.fishky.model.repository.UserRepository;
import com.fishky.model.repository.orm.UserOrmRepository;
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
        return ormRepository.saveAndFlush(user).getIdUser();
    }

    @Override
    public UserEntity read(final Long id) {
        return ormRepository.findById(id).orElse(null);
    }


    @Override
    public UserEntity modify(UserEntity user) {
        return ormRepository.saveAndFlush(user);
    }

    @Override
    public Boolean delete(Long id) {
        ormRepository.deleteById(id);
        return !ormRepository.existsById(id);
    }

}
