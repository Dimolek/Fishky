package com.fishky.controller;

import com.fishky.dto.IdDto;
import com.fishky.dto.dictionary.DictionaryCreateRequestDto;
import com.fishky.dto.dictionary.DictionaryDto;
import com.fishky.dto.dictionary.DictionaryResponseDto;
import com.fishky.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DictionaryController {

    public static final String ENTITY_ID = "id";
    private static final String ADD_DICTIONARY = "/addDictionary";
    private static final String FIND_DICTIONARY = "/findDictionaryById";
    private static final String MODIFY_DICTIONARY = "/modifyDictionary";
    private static final String DELETE_DICTIONARY = "/deleteDictionaryById";
    private static final String FIND_USERS_DICTIONARIES = "/findUsersDictionaries";

    @Autowired
    private DictionaryService service;

    @PostMapping(value = ADD_DICTIONARY)
    public IdDto add(@RequestBody final DictionaryCreateRequestDto dictionary) {
        return service.add(dictionary);
    }

    @GetMapping(value = FIND_DICTIONARY)
    public DictionaryResponseDto find(@RequestParam(value = ENTITY_ID) final String id) {
        return service.read(IdDto.of(Long.valueOf((id))));
    }

    @GetMapping(value = FIND_USERS_DICTIONARIES)
    public List<DictionaryDto> findUsersDictionaries(@RequestParam(value = ENTITY_ID) final String userId) {
        return service.readUsersDictionaries(IdDto.of(Long.valueOf((userId))));
    }

    @PutMapping(value = MODIFY_DICTIONARY)
    public DictionaryDto modify(@RequestBody final DictionaryDto dictionary) {
        return service.modify(dictionary);
    }

    @DeleteMapping(value = DELETE_DICTIONARY)
    public Boolean delete(@RequestBody final IdDto id) {
        return service.delete(id);
    }
}
