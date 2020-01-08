package com.fishky.controller;

import com.fishky.dto.abstracts.IdDto;
import com.fishky.dto.dictionary.DictionaryCreateDto;
import com.fishky.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DictionaryController {

    @Autowired
    private DictionaryService service;


    @RequestMapping(method = RequestMethod.POST, value = "/addDictionary")
    public IdDto add(@RequestBody DictionaryCreateDto dictionary) {
        return service.add(dictionary);
    }

//    @RequestMapping(method = RequestMethod.GET, value = "/findById")
//    public UserDto find(@RequestParam(value="id") String id) {
//        return service.read(IdDto.of(id));
//    }
}
