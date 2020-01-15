package com.fishky.mapper.implementation;

import com.fishky.dto.translation.TranslationCreateDto;
import com.fishky.dto.translation.TranslationDto;
import com.fishky.dto.translation.TranslationsCreateDto;
import com.fishky.mapper.TranslationMapper;
import com.fishky.model.DictionaryEntity;
import com.fishky.model.TranslationEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TranslationMapperImpl implements TranslationMapper {
    @Override
    public TranslationEntity fromDto(final TranslationCreateDto translation, final DictionaryEntity dictionary) {
        return new TranslationEntity(
                translation.getWord(),
                translation.getTranslated(),
                dictionary);
    }

    @Override
    public List<TranslationEntity> fromDto(final TranslationsCreateDto translations, final DictionaryEntity dictionary) {
        return translations.getTranslations()
                .stream()
                .map(tcd -> fromDto(tcd, dictionary))
                .collect(Collectors.toList());
    }

    @Override
    public TranslationEntity fromDto(final TranslationDto translation, final DictionaryEntity dictionary) {
        return new TranslationEntity(
                translation.getId(),
                translation.getWord(),
                translation.getTranslated(),
                dictionary);
    }

    @Override
    public TranslationDto toDto(final TranslationEntity translation) {
        return TranslationDto.of(
                translation.getIdTranslation(),
                translation.getWord(),
                translation.getTranslated(),
                translation.getDictionary().getIdDictionary());
    }
}
