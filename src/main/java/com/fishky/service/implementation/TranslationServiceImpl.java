package com.fishky.service.implementation;

import com.fishky.dto.abstracts.IdDto;
import com.fishky.dto.translation.TranslationCreateDto;
import com.fishky.dto.translation.TranslationDto;
import com.fishky.dto.translation.TranslationsCreateDto;
import com.fishky.mapper.TranslationMapper;
import com.fishky.repository.DictionaryRepository;
import com.fishky.repository.TranslationRepository;
import com.fishky.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TranslationServiceImpl implements TranslationService {

    @Autowired
    private TranslationMapper mapper;

    @Autowired
    private TranslationRepository translationRepository;

    @Autowired
    private DictionaryRepository dictionaryRepository;

    @Override
    public IdDto add(TranslationCreateDto translation) {
        return IdDto.of(
                        translationRepository.save(
                                mapper.fromDto(translation,
                                        dictionaryRepository.read(translation.getDictionaryId()))));
    }

    @Override
    public List<IdDto> addMany(TranslationsCreateDto translations) {
        return translationRepository
                .saveMany(mapper.fromDto(translations,
                        dictionaryRepository.read(translations.getDictionaryId())))
                .stream()
                .map(IdDto::of)
                .collect(Collectors.toList());
    }

    @Override
    public TranslationDto read(IdDto id) {
        return null;
    }

    @Override
    public TranslationDto modify(TranslationDto translation) {
        return mapper.toDto(
                translationRepository.modify(
                        mapper.fromDto(translation, dictionaryRepository.read(translation.getDictionaryId()))));
    }

    @Override
    public Boolean delete(IdDto id) {
        return translationRepository.delete(id.getId());
    }
}
