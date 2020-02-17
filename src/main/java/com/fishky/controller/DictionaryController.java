package com.fishky.controller;

import com.fishky.dto.IdDto;
import com.fishky.dto.NameDto;
import com.fishky.dto.dictionary.DictionaryCreateRequestDto;
import com.fishky.dto.dictionary.DictionaryDto;
import com.fishky.dto.dictionary.DictionaryResponseDto;
import com.fishky.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.fishky.security.service.AuthenticationService.decodeTokenIntoUsername;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
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
    public DictionaryResponseDto add(@RequestBody final DictionaryCreateRequestDto dictionary, final HttpServletRequest request) {
        return service.add(dictionary, NameDto.of(decodeTokenIntoUsername(request)));
    }

    @GetMapping(value = FIND_DICTIONARY)
    public DictionaryResponseDto find(@RequestParam(value = ENTITY_ID) final String id) {
        return service.read(IdDto.of(Long.valueOf((id))));
    }

    @GetMapping(value = FIND_USERS_DICTIONARIES)
    public List<DictionaryDto> findUsersDictionaries(final HttpServletRequest request) {
        return service.readUsersDictionaries(NameDto.of(decodeTokenIntoUsername(request)));
    }

    @PutMapping(value = MODIFY_DICTIONARY)
    public DictionaryDto modify(@RequestBody final DictionaryDto dictionary, final HttpServletRequest request) {
        return service.modify(dictionary, NameDto.of(decodeTokenIntoUsername(request)));
    }

    @PostMapping(value = DELETE_DICTIONARY)
    public Boolean delete(@RequestBody final IdDto id) {
        return service.delete(id);
    }
}
