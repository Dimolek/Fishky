package com.fishky.service;

import com.fishky.dto.IdDto;
import com.fishky.dto.user.UserDto;
import com.fishky.model.UserEntity;
import com.fishky.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserService service;

    @Mock
    private UserRepository repository;

    @Test
    public void read_whenExistingUserIdIsProvided_thenRetrievedUserContentIsCorrect() {

        final IdDto dto = IdDto.of(18L);
        final UserEntity userEntity = new UserEntity(18L, "TestUser", "TestPassword", Timestamp.valueOf(LocalDateTime.now()));

        Mockito.when(repository.read(dto.getId())).thenReturn(userEntity);

        UserDto resultUser = service.read(dto);
        assertAll("Should return correct user data",
                () -> assertEquals(18L, resultUser.getId()),
                () -> assertEquals("TestUser", resultUser.getUsername()),
                () -> assertEquals("TestPassword", resultUser.getPassword())
        );
    }

    @Test
    public void read_whenUserIdDoesNotExist_thenNullPointerExceptionIsThrown() {

        final IdDto dto = IdDto.of(62000L);

        Mockito.when(repository.read(dto.getId())).thenReturn(null);

        assertThrows(NullPointerException.class, () -> service.read(dto));
    }

    @Test
    void add() {
    }

    @Test
    void modify() {
    }

    @Test
    void delete() {
    }
}