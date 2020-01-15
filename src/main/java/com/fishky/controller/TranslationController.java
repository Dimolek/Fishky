package com.fishky.controller;

import com.fishky.dto.abstracts.IdDto;
import com.fishky.dto.translation.TranslationCreateDto;
import com.fishky.dto.translation.TranslationDto;
import com.fishky.dto.translation.TranslationsCreateDto;
import com.fishky.properties.ConstURLMapping;
import com.fishky.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TranslationController {

    @Autowired
    private TranslationService service;

    @PostMapping(value = ConstURLMapping.ADD_TRANSLATION)
    public IdDto add(@RequestBody final TranslationCreateDto translation) {
        return service.add(translation);
    }

    @PostMapping(value = ConstURLMapping.ADD_TRANSLATION_COLLECTION)
    public List<IdDto> addMany(@RequestBody final TranslationsCreateDto translations) {
        return service.addMany(translations);
    }

    @PutMapping(value = ConstURLMapping.MODIFY_TRANSLATION)
    public TranslationDto modify(@RequestBody final TranslationDto translation) {
        return service.modify(translation);
    }

    @DeleteMapping(value = ConstURLMapping.DELETE_TRANSLATION)
    public Boolean delete(@RequestBody final IdDto id) {
        return service.delete(id);
    }
}
