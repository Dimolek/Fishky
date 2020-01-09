package com.fishky.controller;

import com.fishky.dto.abstracts.IdDto;
import com.fishky.dto.translation.TranslationCreateDto;
import com.fishky.dto.translation.TranslationsCreateDto;
import com.fishky.properties.ConstURLMapping;
import com.fishky.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TranslationController {

    @Autowired
    private TranslationService service;

    @RequestMapping(method = RequestMethod.POST, value = ConstURLMapping.ADD_TRANSLATION)
    public IdDto add(@RequestBody final TranslationCreateDto translation) {
        return service.add(translation);
    }

    @RequestMapping(method = RequestMethod.POST, value = ConstURLMapping.ADD_TRANSLATION_COLLECTION)
    public List<IdDto> addMany(@RequestBody final TranslationsCreateDto translations) {
        return service.addMany(translations);
    }

}
