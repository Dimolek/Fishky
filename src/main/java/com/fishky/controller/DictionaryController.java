package com.fishky.controller;

import com.fishky.dto.abstracts.IdDto;
import com.fishky.dto.dictionary.DictionaryCreateDto;
import com.fishky.dto.dictionary.DictionaryDto;
import com.fishky.dto.dictionary.DictionaryResponseDto;
import com.fishky.properties.ConstURLMapping;
import com.fishky.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DictionaryController {

    @Autowired
    private DictionaryService service;

    @RequestMapping(method = RequestMethod.POST, value = ConstURLMapping.ADD_DICTIONARY)
    public IdDto add(@RequestBody final DictionaryCreateDto dictionary) {
        return service.add(dictionary);
    }

    @RequestMapping(method = RequestMethod.GET, value = ConstURLMapping.FIND_DICTIONARY)
    public DictionaryResponseDto find(@RequestParam(value = ConstURLMapping.ENTITY_ID) final String id) {
        return service.read(IdDto.of(id));
    }

    @RequestMapping(method = RequestMethod.GET, value = ConstURLMapping.FIND_USERS_DICTIONARIES)
    public List<DictionaryDto> findUsersDictionaries(@RequestParam(value = ConstURLMapping.ENTITY_ID) final String userId) {
        return service.readUsersDictionaries(IdDto.of(userId));
    }

    @RequestMapping(method = RequestMethod.PUT, value = ConstURLMapping.MODIFY_DICTIONARY)
    public DictionaryDto modify(@RequestBody final DictionaryDto dictionary) {
        return service.modify(dictionary);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = ConstURLMapping.DELETE_DICTIONARY)
    public Boolean delete(@RequestBody final IdDto id) {
        return service.delete(id);
    }
}
