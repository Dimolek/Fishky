package com.fishky.service.implementation;

import com.fishky.dto.abstracts.IdDto;
import com.fishky.dto.dictionary.DictionaryCreateDto;
import com.fishky.dto.dictionary.DictionaryDto;
import com.fishky.dto.dictionary.DictionaryResponseDto;
import com.fishky.mapper.DictionaryMapper;
import com.fishky.repository.DictionaryRepository;
import com.fishky.repository.UserRepository;
import com.fishky.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DictionaryServiceImpl implements DictionaryService {

    @Autowired
    private DictionaryMapper mapper;

    @Autowired
    private DictionaryRepository dictionaryRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public IdDto add(final DictionaryCreateDto dictionary) {
        return IdDto.of(
                        dictionaryRepository.save(
                                mapper.fromDto(dictionary, userRepository.read(dictionary.getUserId()))));
    }

    @Override
    public DictionaryResponseDto read(final IdDto id) {
        return mapper.toDto(
                dictionaryRepository.read(id.getId()));
    }

    @Override
    public List<DictionaryDto> readUsersDictionaries(IdDto userId) {
        return mapper.toDto(
                dictionaryRepository.readUsersDictionaries(userId.getId()));
    }


    @Override
    public DictionaryResponseDto modify(final DictionaryDto dictionary) {
        return mapper.toDto(
                dictionaryRepository.modify(
                        mapper.fromDto(dictionary, userRepository.read(dictionary.getUserId()))));
    }

    @Override
    public Boolean delete(final IdDto id) {
        //Also, delete all dependent translations (or in DictionaryRepository)
        return dictionaryRepository.delete(id.getId());
    }
}
