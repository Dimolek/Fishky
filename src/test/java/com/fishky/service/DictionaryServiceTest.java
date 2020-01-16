package com.fishky.service;

import com.fishky.dto.IdDto;
import com.fishky.dto.dictionary.DictionaryResponseDto;
import com.fishky.model.DictionaryEntity;
import com.fishky.model.UserEntity;
import com.fishky.repository.DictionaryRepository;
import com.fishky.repository.UserRepository;
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
class DictionaryServiceTest {

    @InjectMocks
    private DictionaryService dictionaryService;

    @Mock
    private DictionaryRepository dictionaryRepository;

    @Mock
    private UserRepository userRepository;

    @Test
    void add() {
    }

    @Test
    void read_whenExistingDictionaryIdIsProvided_thenRetrievedDictionaryContentIsCorrect() {

        final IdDto dto = IdDto.of(70L);

        final UserEntity userEntity = new UserEntity(
                18L, "TestUser", "TestPassword", Timestamp.valueOf(LocalDateTime.now()));
        final DictionaryEntity dictionaryEntity = new DictionaryEntity(
                70L, "Mandarin", "Unit4", userEntity);

        Mockito.when(dictionaryRepository.read(dto.getId())).thenReturn(dictionaryEntity);

        DictionaryResponseDto resultDictionary = dictionaryService.read(dto);
        assertAll("Should return correct user data",
                () -> assertEquals(70L, resultDictionary.getId()),
                () -> assertEquals("Mandarin", resultDictionary.getLanguage()),
                () -> assertEquals("Unit4", resultDictionary.getName())
        );
    }

    @Test
    void readUsersDictionaries() {
    }

    @Test
    void modify() {
    }

    @Test
    void delete() {
    }
}