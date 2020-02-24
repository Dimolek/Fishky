package com.fishky.service;

import com.fishky.dto.IdDto;
import com.fishky.dto.translation.TranslationCreateRequestDto;
import com.fishky.dto.translation.TranslationDto;
import com.fishky.dto.translation.TranslationsCreateRequestDto;
import com.fishky.mapper.TranslationMapper;
import com.fishky.policy.DictionaryPolicy;
import com.fishky.policy.TranslationPolicy;
import com.fishky.repository.DictionaryRepository;
import com.fishky.repository.TranslationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TranslationService {

    @Autowired
    private TranslationRepository translationRepository;

    @Autowired
    private DictionaryRepository dictionaryRepository;

    @Autowired
    private DictionaryPolicy dictionaryPolicy;

    @Autowired
    private TranslationPolicy translationPolicy;

    public TranslationDto add(TranslationCreateRequestDto translation) {
        return TranslationMapper.toDto(
                        translationRepository.save(
                                TranslationMapper.fromDto(translation,
                                        dictionaryRepository.read(translation.getDictionaryId())
                                )
                        )
        );
    }

    public List<IdDto> addMany(TranslationsCreateRequestDto translations) {
        dictionaryPolicy.dictionaryExists(translations.getDictionaryId());
        return translationRepository
                .saveMany(TranslationMapper.fromDto(translations,
                        dictionaryRepository.read(translations.getDictionaryId())))
                .stream()
                .map(IdDto::of)
                .collect(Collectors.toList());
    }

    public TranslationDto read(IdDto id) {
        return null;
    }

    public TranslationDto modify(TranslationDto translation) {
        translationPolicy.translationExists(translation.getId());
        return TranslationMapper.toDto(
                translationRepository.modify(
                        TranslationMapper.fromDto(translation, dictionaryRepository.read(translation.getDictionaryId()))
                )
        );
    }

    public Boolean delete(IdDto id) {
        translationPolicy.translationExists(id.getId());
        return translationRepository.delete(id.getId());
    }
}
