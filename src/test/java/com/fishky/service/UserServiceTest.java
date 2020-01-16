package com.fishky.service;

import com.fishky.dto.IdDto;
import com.fishky.dto.user.UserCreateRequestDto;
import com.fishky.dto.user.UserDto;
import com.fishky.model.UserEntity;
import com.fishky.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserService service;

    @Mock
    private UserRepository repository;

    @Test
    void add_whenCorrectUserContentIsProvided_thenNewIdIsReturned() {

        final Long id = 39L;
        final UserCreateRequestDto userDto = UserCreateRequestDto.of("User1", "qwerty");

        when(repository.save(any())).thenReturn(id);

        IdDto idDto = service.add(userDto);
        assertEquals(39L, idDto.getId());
    }

    @Test
    public void add_whenIncorrectUserContentIsProvided_thenNullPointerExceptionIsThrown() {

        final UserCreateRequestDto userDto = UserCreateRequestDto.of("User1", null);

        when(repository.save(any())).thenThrow(new NullPointerException());

        assertThrows(NullPointerException.class, () -> service.add(userDto));

        // only mock is tested, need to implement validation methods
    }

    @Test
    public void read_whenExistingUserIdIsProvided_thenRetrievedUserContentIsCorrect() {

        final IdDto dto = IdDto.of(18L);
        final UserEntity userEntity = new UserEntity(18L, "TestUser", "TestPassword", Timestamp.valueOf(LocalDateTime.now()));

        when(repository.read(dto.getId())).thenReturn(userEntity);

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

        when(repository.read(dto.getId())).thenReturn(null);

        assertThrows(NullPointerException.class, () -> service.read(dto));
    }

    @Test
    void modify_whenCorrectUserContentIsProvided_thenModifiedUserIsReturned() {

        final UserDto userDto = UserDto.of(39L,"User1", "qwerty");
        final UserEntity userEntity = new UserEntity(39L, "User1", "qwerty", Timestamp.valueOf(LocalDateTime.now()));

        when(repository.modify(any())).thenReturn(userEntity);
        when(repository.read(userDto.getId())).thenReturn(userEntity);

        UserDto resultUser = service.modify(userDto);
        assertAll("Should return correct user data",
                () -> assertEquals(39L, resultUser.getId()),
                () -> assertEquals("TestUser", resultUser.getUsername()),
                () -> assertEquals("TestPassword", resultUser.getPassword())
        );
    }

    @Test
    void delete() {

        // only mock is tested, need to implement validation methods
    }
}