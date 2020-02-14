package com.fishky.service;

import com.fishky.dto.IdDto;
import com.fishky.dto.translation.TranslationCreateRequestDto;
import com.fishky.dto.translation.TranslationDto;
import com.fishky.dto.translation.TranslationsCreateRequestDto;
import com.fishky.model.DictionaryEntity;
import com.fishky.model.TranslationEntity;
import com.fishky.model.UserEntity;
import com.fishky.repository.DictionaryRepository;
import com.fishky.repository.TranslationRepository;
import com.fishky.security.config.AccountRoles;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TranslationServiceTest {

    @InjectMocks
    private TranslationService translationService;

    @Mock
    private TranslationRepository translationRepository;

    @Mock
    private DictionaryRepository dictionaryRepository;



    @Test
    void add_whenCorrectTranslationContentIsProvided_thenNewTranslationDtoIsReturned() {
        //given
        final TranslationCreateRequestDto translationCreateDto = TranslationCreateRequestDto.of("car", "samochod", 1L);
        final UserEntity userEntity = new UserEntity(12L, "TestUser", "TestPassword", Timestamp.valueOf(LocalDateTime.now()), AccountRoles.USER);
        final DictionaryEntity dictionaryEntity = new DictionaryEntity(1L, "Unit2", "German", userEntity);
        final TranslationEntity translationEntity = new TranslationEntity(14L, "samochód", "car", dictionaryEntity);

        when(translationRepository.save(any())).thenReturn(translationEntity);
        when(dictionaryRepository.read(translationCreateDto.getDictionaryId())).thenReturn(dictionaryEntity);

        //when
        TranslationDto translationDto = translationService.add(translationCreateDto);

        //then
        assertAll("Should return correct translation data",
                () -> assertEquals(14L, translationDto.getId()),
                () -> assertEquals("samochód", translationDto.getWord()),
                () -> assertEquals("car", translationDto.getTranslated())
        );
    }

    @Test
    public void add_whenIncorrectTranslationContentIsProvided_thenNullPointerExceptionIsThrown() {
        // only mock is tested, need to implement validation methods
    }

    @Test
    void addMany_whenCorrectTranslationsCollectionIsProvided_thenNewIdListIsReturned() {
        //given
        final Long id = 5L;
        final List<TranslationCreateRequestDto> translationDtoList = new ArrayList<>();
        translationDtoList.add(TranslationCreateRequestDto.of("car", "samochod", 1L));
        translationDtoList.add(TranslationCreateRequestDto.of("train", "pociag", 1L));
        translationDtoList.add(TranslationCreateRequestDto.of("airplane", "samolot", 1L));
        final TranslationsCreateRequestDto translations = TranslationsCreateRequestDto.of(translationDtoList, 1L);

        when(translationRepository.saveMany(any())).thenReturn(new ArrayList<Long>(Arrays.asList(1L, 2L, 3L)));

        //when
        List<IdDto> idList = translationService.addMany(translations);

        //then
        assertAll("Should return correct id's of translations",
                () -> assertEquals(1L, idList.get(0).getId()),
                () -> assertEquals(2L, idList.get(1).getId()),
                () -> assertEquals(3L, idList.get(2).getId())
        );
    }

//    @Test
//    void read_whenExistingTranslationIdIsProvided_thenRetrievedTranslationContentIsCorrect() {
//    }

    @Test
    void modify_whenCorrectTranslationContentIsProvided_thenModifiedTranslationIsReturned() {
        //given
        final TranslationDto translationDto = TranslationDto.of(15L, "car", "samochod", 1L);
        final UserEntity userEntity = new UserEntity(12L, "TestUser", "TestPassword", Timestamp.valueOf(LocalDateTime.now()), AccountRoles.USER);
        final DictionaryEntity dictionaryEntity = new DictionaryEntity(39L, "English", "Unit21", userEntity);

        final TranslationEntity translationEntity = new TranslationEntity(15L, "car", "samochod", dictionaryEntity);

        when(translationRepository.modify(any())).thenReturn(translationEntity);
        when(dictionaryRepository.read(translationDto.getDictionaryId())).thenReturn(dictionaryEntity);

        //when
        TranslationDto resultTranslation = translationService.modify(translationDto);

        //then
        assertAll("Should return correct, modified translation data",
                () -> assertEquals(15L, resultTranslation.getId()),
                () -> assertEquals("car", resultTranslation.getWord()),
                () -> assertEquals("samochod", resultTranslation.getTranslated())
        );
    }

    @Test
    void delete() {
        // only mock is tested, need to implement validation methods
    }
}