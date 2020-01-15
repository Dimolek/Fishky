package com.fishky.repository.implemenetation;

import com.fishky.dto.abstracts.IdDto;
import com.fishky.model.UserEntity;
import com.fishky.repository.orm.UserOrmRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class UserRepositoryImplTest {

    @InjectMocks
    private UserRepositoryImpl repository;

    @Mock
    private UserOrmRepository ormRepository;

    @Test
    public void read_whenExistingUserIdIsProvided_thenRetrievedUserDataIsCorrect() {

        final IdDto dto = IdDto.of(1L);
        final UserEntity userEntity = new UserEntity(1L, "TestUser", "TestPassword", Timestamp.valueOf(LocalDateTime.now()));

        Mockito.when(ormRepository.findById(1L)).thenReturn(java.util.Optional.of(userEntity));

        UserEntity resultUser = repository.read(1L);
        assertAll("Should return correct user data",
                () -> assertEquals(1, resultUser.getIdUser()),
                () -> assertEquals("TestUser", resultUser.getUsername()),
                () -> assertEquals("TestPassword", resultUser.getPassword())
        );
    }
}