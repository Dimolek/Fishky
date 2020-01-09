package com.fishky.service.implementation;

import com.fishky.adapter.TranslationAdapter;
import com.fishky.dto.abstracts.IdDto;
import com.fishky.dto.translation.TranslationCreateDto;
import com.fishky.dto.translation.TranslationDto;
import com.fishky.dto.translation.TranslationsCreateDto;
import com.fishky.model.repository.DictionaryRepository;
import com.fishky.model.repository.TranslationRepository;
import com.fishky.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TranslationServiceImpl implements TranslationService {

    @Autowired
    private TranslationAdapter adapter;

    @Autowired
    private TranslationRepository translationRepository;

    @Autowired
    private DictionaryRepository dictionaryRepository;

    @Override
    public IdDto add(TranslationCreateDto translation) {
        return IdDto.of(
                String.valueOf(
                        translationRepository.save(
                                adapter.fromDto(translation,
                                        dictionaryRepository.read(Long.valueOf(translation.getDictionaryId()))))));
    }

    @Override
    public List<IdDto> addMany(TranslationsCreateDto translations) {
        return translationRepository
                .saveMany(adapter.fromDto(translations,
                        dictionaryRepository.read(Long.valueOf(translations.getDictionaryId()))))
                .stream()
                .map(id -> IdDto.of(String.valueOf(id)))
                .collect(Collectors.toList());
    }

    @Override
    public TranslationDto read(IdDto id) {
        return null;
    }

    @Override
    public TranslationDto modify(TranslationDto translation) {
        return null;
    }

    @Override
    public Boolean delete(IdDto id) {
        return null;
    }
}
