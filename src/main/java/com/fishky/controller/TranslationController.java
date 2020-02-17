package com.fishky.controller;

import com.fishky.dto.IdDto;
import com.fishky.dto.translation.TranslationCreateRequestDto;
import com.fishky.dto.translation.TranslationDto;
import com.fishky.dto.translation.TranslationsCreateRequestDto;
import com.fishky.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TranslationController {

    private static final String ADD_TRANSLATION = "/addTranslation";
    private static final String ADD_TRANSLATION_COLLECTION = "/addTranslationCollection";
    private static final String MODIFY_TRANSLATION = "/modifyTranslation";
    private static final String DELETE_TRANSLATION = "/deleteTranslationById";

    @Autowired
    private TranslationService service;

    @PostMapping(value = ADD_TRANSLATION)
    public TranslationDto add(@RequestBody final TranslationCreateRequestDto translation) {
        return service.add(translation);
    }

    @PostMapping(value = ADD_TRANSLATION_COLLECTION)
    public List<IdDto> addMany(@RequestBody final TranslationsCreateRequestDto translations) {
        return service.addMany(translations);
    }

    @PutMapping(value = MODIFY_TRANSLATION)
    public TranslationDto modify(@RequestBody final TranslationDto translation) {
        return service.modify(translation);
    }

    @PostMapping(value = DELETE_TRANSLATION)
    public Boolean delete(@RequestBody final IdDto id) {
        return service.delete(id);
    }
}
