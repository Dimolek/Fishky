package com.fishky.service;

import com.fishky.dto.IdDto;
import com.fishky.dto.dictionary.DictionaryCreateRequestDto;
import com.fishky.dto.dictionary.DictionaryDto;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DictionaryServiceTest {

    @InjectMocks
    private DictionaryService dictionaryService;

    @Mock
    private DictionaryRepository dictionaryRepository;

    @Mock
    private UserRepository userRepository;

    @Test
    void add_whenCorrectDictionaryContentIsProvided_thenNewIdIsReturned() {

        final Long id = 39L;
        final DictionaryCreateRequestDto dictionaryDto = DictionaryCreateRequestDto.of("Unit2", "German", 12L);
        final UserEntity userEntity = new UserEntity(12L, "TestUser", "TestPassword", Timestamp.valueOf(LocalDateTime.now()));

        when(dictionaryRepository.save(any())).thenReturn(id);
        when(userRepository.read(dictionaryDto.getUserId())).thenReturn(userEntity);

        IdDto idDto = dictionaryService.add(dictionaryDto);
        assertEquals(39L, idDto.getId());
    }

    @Test
    public void add_whenIncorrectUserContentIsProvided_thenNullPointerExceptionIsThrown() {

        final DictionaryCreateRequestDto dictionaryDto = DictionaryCreateRequestDto.of("User1", null, 12L);

        when(dictionaryRepository.save(any())).thenThrow(new NullPointerException());

        assertThrows(NullPointerException.class, () -> dictionaryService.add(dictionaryDto));

        // only mock is tested, need to implement validation methods
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
        assertAll("Should return correct dictionary data",
                () -> assertEquals(70L, resultDictionary.getId()),
                () -> assertEquals("Mandarin", resultDictionary.getLanguage()),
                () -> assertEquals("Unit4", resultDictionary.getName())
        );
    }

    @Test
    public void read_whenDictionaryIdDoesNotExist_thenNullPointerExceptionIsThrown() {

        final IdDto dto = IdDto.of(62000L);

        when(dictionaryRepository.read(dto.getId())).thenReturn(null);

        assertThrows(NullPointerException.class, () -> dictionaryService.read(dto));
    }

    @Test
    void readUsersDictionaries() {

        //TODO
    }

    @Test
    void modify_whenCorrectDictionaryContentIsProvided_thenModifiedDictionaryIsReturned() {

        final DictionaryDto dictionaryDto = DictionaryDto.of(39L,"Unit21", "English", 12L);
        final UserEntity userEntity = new UserEntity(12L, "TestUser", "TestPassword", Timestamp.valueOf(LocalDateTime.now()));
        final DictionaryEntity dictionaryEntity = new DictionaryEntity(39L, "English", "Unit21", userEntity);

        when(dictionaryRepository.modify(any())).thenReturn(dictionaryEntity);
        when(userRepository.read(dictionaryDto.getUserId())).thenReturn(userEntity);

        DictionaryDto resultDictionary = dictionaryService.modify(dictionaryDto);
        assertAll("Should return correct dictionary data",
                () -> assertEquals(39L, resultDictionary.getId()),
                () -> assertEquals("Unit21", resultDictionary.getName()),
                () -> assertEquals("English", resultDictionary.getLanguage())
        );
    }

    @Test
    void delete() {
    }
}