package com.fishky.policy;

import com.fishky.policy.validation.annotations.Policy;
import com.fishky.repository.orm.UserOrmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Policy
public class UserPolicy {

    @Autowired
    private UserOrmRepository ormRepository;

    public void userAlreadyExists(final String username) {
        if (ormRepository.existsByUsername(username))
            throw (new RuntimeException("User already exists"));
    }

    public void userExists(final Long id) {
        if (!ormRepository.existsById(id))
            throw (new RuntimeException("User does not exist"));
    }

    public void userExists(final String username) {
        if (!ormRepository.existsByUsername(username))
            throw (new RuntimeException("User does not exist"));
    }

    public ResponseEntity<String> checkAuthentication(final UsernamePasswordAuthenticationToken user) {
        if(user == null) {
            return new ResponseEntity<>("Unauthorized", HttpStatus.UNAUTHORIZED);
        } else {
            return new ResponseEntity<>("Authorized", HttpStatus.ACCEPTED);
        }
    }
}
