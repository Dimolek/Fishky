package com.fishky.controller;

import com.fishky.dto.abstracts.IdDto;
import com.fishky.dto.dictionary.DictionaryCreateDto;
import com.fishky.dto.dictionary.DictionaryDto;
import com.fishky.properties.ConstURLMapping;
import com.fishky.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DictionaryController {

    @Autowired
    private DictionaryService service;

    @RequestMapping(method = RequestMethod.POST, value = ConstURLMapping.ADD_DICTIONARY)
    public IdDto add(@RequestBody DictionaryCreateDto dictionary) {
        return service.add(dictionary);
    }

    @RequestMapping(method = RequestMethod.GET, value = ConstURLMapping.FIND_DICTIONARY)
    public DictionaryDto find(@RequestParam(value = ConstURLMapping.ENTITY_ID) String id) {
        return service.read(IdDto.of(id));
    }
}
