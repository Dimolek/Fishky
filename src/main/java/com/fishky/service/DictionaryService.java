package com.fishky.service;

import com.fishky.dto.IdDto;
import com.fishky.dto.NameDto;
import com.fishky.dto.dictionary.DictionaryCreateRequestDto;
import com.fishky.dto.dictionary.DictionaryDto;
import com.fishky.dto.dictionary.DictionaryResponseDto;
import com.fishky.mapper.DictionaryMapper;
import com.fishky.policy.DictionaryPolicy;
import com.fishky.policy.UserPolicy;
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

    @Autowired
    private UserPolicy userPolicy;

    @Autowired
    private DictionaryPolicy dictionaryPolicy;

    public DictionaryResponseDto add(final DictionaryCreateRequestDto dictionary, final NameDto username) {
        userPolicy.userExists(username.getName());
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

    public List<DictionaryDto> readUsersDictionaries(final NameDto username) {
        userPolicy.userExists(username.getName());
        return DictionaryMapper.toDto(
                dictionaryRepository.readUsersDictionaries(username.getName())
        );
    }


    public DictionaryResponseDto modify(final DictionaryDto dictionary, final NameDto username) {
        userPolicy.userExists(username.getName());
        dictionaryPolicy.dictionaryExists(dictionary.getId());
        return DictionaryMapper.toDto(
                dictionaryRepository.modify(
                        DictionaryMapper.fromDto(dictionary, userRepository.readByUsername(username.getName()))
                )
        );
    }

    public Boolean delete(final IdDto id) {
        //Also, delete all dependent translations (or in DictionaryRepository)
        dictionaryPolicy.dictionaryExists(id.getId());
        return dictionaryRepository.delete(id.getId());
    }
}
