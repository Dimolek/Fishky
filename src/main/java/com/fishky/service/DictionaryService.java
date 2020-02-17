package com.fishky.service;

import com.fishky.dto.IdDto;
import com.fishky.dto.NameDto;
import com.fishky.dto.dictionary.DictionaryCreateRequestDto;
import com.fishky.dto.dictionary.DictionaryDto;
import com.fishky.dto.dictionary.DictionaryResponseDto;
import com.fishky.mapper.DictionaryMapper;
import com.fishky.repository.DictionaryRepository;
import com.fishky.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DictionaryService {

    @Autowired
    private DictionaryRepository dictionaryRepository;

    @Autowired
    private UserRepository userRepository;


    public DictionaryResponseDto add(final DictionaryCreateRequestDto dictionary, final NameDto username) {
        return DictionaryMapper.toDto(
                        dictionaryRepository.save(
                                DictionaryMapper.fromDto(dictionary, userRepository.readByUsername(username.getName()))
                        )
        );
    }

    public DictionaryResponseDto read(final IdDto id) {
        return DictionaryMapper.toDto(
                dictionaryRepository.read(id.getId())
        );
    }

    public List<DictionaryDto> readUsersDictionaries(final NameDto userName) {
        return DictionaryMapper.toDto(
                dictionaryRepository.readUsersDictionaries(userName.getName())
        );
    }


    public DictionaryResponseDto modify(final DictionaryDto dictionary, final NameDto username) {
        return DictionaryMapper.toDto(
                dictionaryRepository.modify(
                        DictionaryMapper.fromDto(dictionary, userRepository.readByUsername(username.getName()))
                )
        );
    }

    public Boolean delete(final IdDto id) {
        //Also, delete all dependent translations (or in DictionaryRepository)
        return dictionaryRepository.delete(id.getId());
    }
}
