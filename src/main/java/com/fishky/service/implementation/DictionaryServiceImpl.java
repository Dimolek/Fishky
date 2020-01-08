package com.fishky.service.implementation;

import com.fishky.adapter.DictionaryAdapter;
import com.fishky.dto.abstracts.IdDto;
import com.fishky.dto.dictionary.DictionaryCreateDto;
import com.fishky.model.repository.DictionaryRepository;
import com.fishky.model.repository.UserRepository;
import com.fishky.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryServiceImpl implements DictionaryService {

    @Autowired
    private DictionaryAdapter adapter;

    @Autowired
    private DictionaryRepository dictionaryRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public IdDto add(DictionaryCreateDto dictionary) {
        return IdDto.of(
                String.valueOf(
                        dictionaryRepository.save(
                                adapter.fromDto(dictionary, userRepository.read(
                                        Long.valueOf(dictionary.getUserId()))))));
    }
}
