package com.fishky.model.service;

import com.fishky.adapter.implementation.UserAdapterImpl;
import com.fishky.dto.abstracts.IdDto;
import com.fishky.dto.user.UserDto;
import com.fishky.model.UserEntity;
import com.fishky.model.repository.UserRepository;
import com.fishky.model.repository.implemenetation.UserRepositoryImpl;
import com.fishky.service.UserService;
import com.fishky.service.implementation.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { UserServiceImpl.class, UserRepositoryImpl.class, UserAdapterImpl.class})
public class UserServiceImplTest {

    @Autowired
    private UserService service;

    @MockBean
    private UserRepository repository;

    @Test
    public void read_whenExistingUserIdIsProvided_thenRetrievedUserDataIsCorrect() {

        final IdDto dto = IdDto.of("1");
        final UserEntity userEntity = new UserEntity(1, "TestUser", "TestPassword", Timestamp.valueOf(LocalDateTime.now()));

        Mockito.when(repository.read(Long.valueOf(dto.getId()))).thenReturn(userEntity);

        UserDto resultUser = service.read(dto);
        assertAll("Should return correct user data",
                () -> assertEquals("1", resultUser.getId()),
                () -> assertEquals("TestUser", resultUser.getUsername()),
                () -> assertEquals("TestPassword", resultUser.getPassword())
        );
   }

    @Test
    public void read_whenUserIdDoesNotExist_thenNullPointerExceptionIsThrown() {

        final IdDto dto = IdDto.of("62000");

        Mockito.when(repository.read(Long.valueOf(dto.getId()))).thenReturn(null);

        assertThrows(NullPointerException.class, () -> service.read(dto));
    }
}
