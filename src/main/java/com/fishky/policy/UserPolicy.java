package com.fishky.policy;

import com.fishky.repository.orm.UserOrmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserPolicy {

    @Autowired
    private UserOrmRepository ormRepository;

    public void userExists(final String username)  {
        if(ormRepository.existsByUsername(username))
        {
            throw (new RuntimeException("User already exists"));
        }
    }
}
