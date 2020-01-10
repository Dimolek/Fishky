package com.fishky.service.implementation;

import com.fishky.adapter.DictionaryAdapter;
import com.fishky.dto.abstracts.IdDto;
import com.fishky.dto.dictionary.DictionaryCreateDto;
import com.fishky.dto.dictionary.DictionaryDto;
import com.fishky.dto.dictionary.DictionaryResponseDto;
import com.fishky.model.repository.DictionaryRepository;
import com.fishky.model.repository.UserRepository;
import com.fishky.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictionaryServiceImpl implements DictionaryService {

    @Autowired
    private DictionaryAdapter adapter;

    @Autowired
    private DictionaryRepository dictionaryRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public IdDto add(final DictionaryCreateDto dictionary) {
        return IdDto.of(
                String.valueOf(
                        dictionaryRepository.save(
                                adapter.fromDto(dictionary, userRepository.read(
                                        Long.valueOf(dictionary.getUserId()))))));
    }

    @Override
    public DictionaryResponseDto read(final IdDto id) {
        return adapter.toDto(
                dictionaryRepository.read(
                        Long.valueOf(id.getId())));
    }

    @Override
    public List<DictionaryDto> readUsersDictionaries(IdDto userId) {
        return adapter.toDto(
                dictionaryRepository.readUsersDictionaries(Long.valueOf(userId.getId())));
    }


    @Override
    public DictionaryResponseDto modify(final DictionaryDto dictionary) {
        return adapter.toDto(
                dictionaryRepository.modify(
                        adapter.fromDto(dictionary, userRepository.read(
                                Long.valueOf(dictionary.getUserId())))));
    }

    @Override
    public Boolean delete(final IdDto id) {
        //Also, delete all dependent translations (or in DictionaryRepository)
        return dictionaryRepository.delete(Long.valueOf(id.getId()));
    }
}
