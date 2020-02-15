package com.fishky.service;

import com.fishky.dto.IdDto;
import com.fishky.dto.user.UserCreateRequestDto;
import com.fishky.dto.user.UserDto;
import com.fishky.model.UserEntity;
import com.fishky.policy.UserPolicy;
import com.fishky.repository.UserRepository;
import com.fishky.security.config.AccountRoles;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserService service;

    @Mock
    private UserPolicy userPolicy;

    @Mock
    private UserRepository repository;

    @Test
    void add_whenCorrectUserContentIsProvided_thenNewIdIsReturned() {
        //given
        final Long id = 39L;
        final UserCreateRequestDto userDto = UserCreateRequestDto.of("User1", "qwerty", "qwerty");

        when(repository.save(any())).thenReturn(id);
        doNothing().when(userPolicy).userExists(any());

        //when
        IdDto idDto = service.add(userDto);

        //then
        assertEquals(39L, idDto.getId());
    }

/*    @Test
    public void add_whenIncorrectUserContentIsProvided_thenNullPointerExceptionIsThrown() {
        //given
        final UserCreateRequestDto userDto = UserCreateRequestDto.of("User1", null, null);

        //when
        when(repository.save(any())).thenThrow(new NullPointerException());

        //then
        assertThrows(NullPointerException.class, () -> service.add(userDto));

        // only mock is tested, need to implement validation methods
    }*/

    @Test
    public void read_whenExistingUserIdIsProvided_thenRetrievedUserContentIsCorrect() {
        //given
        final IdDto dto = IdDto.of(18L);
        final UserEntity userEntity = new UserEntity(18L, "TestUser", "TestPassword", Timestamp.valueOf(LocalDateTime.now()), AccountRoles.USER);

        when(repository.readById(dto.getId())).thenReturn(userEntity);

        //when
        UserDto resultUser = service.readById(dto);

        //then
        assertAll("Should return correct user data",
                () -> assertEquals(18L, resultUser.getId()),
                () -> assertEquals("TestUser", resultUser.getUsername()),
                () -> assertEquals("TestPassword", resultUser.getPassword())
        );
    }

    @Test
    public void read_whenUserIdDoesNotExist_thenNullPointerExceptionIsThrown() {
        //given
        final IdDto dto = IdDto.of(62000L);

        //when
        when(repository.readById(dto.getId())).thenReturn(null);

        //then
        assertThrows(NullPointerException.class, () -> service.readById(dto));
    }

    @Test
    void modify_whenCorrectUserContentIsProvided_thenModifiedUserIsReturned() {
        //given
        final UserDto userDto = UserDto.of(39L,"User1", "qwerty");
        final UserEntity userEntity = new UserEntity(39L, "User1", "qwerty", Timestamp.valueOf(LocalDateTime.now()), AccountRoles.USER);

        when(repository.modify(any())).thenReturn(userEntity);
        when(repository.readById(userDto.getId())).thenReturn(userEntity);

        //when
        UserDto resultUser = service.modify(userDto);

        //then
        assertAll("Should return correct modified user data",
                () -> assertEquals(39L, resultUser.getId()),
                () -> assertEquals("User1", resultUser.getUsername()),
                () -> assertEquals("qwerty", resultUser.getPassword())
        );
    }

    @Test
    void delete() {

        // only mock is tested, need to implement validation methods
    }
}