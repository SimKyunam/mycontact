package com.fastcampus.javaallinone.project3.mycontact.controller;

import com.fastcampus.javaallinone.project3.mycontact.controller.dto.PersonDto;
import com.fastcampus.javaallinone.project3.mycontact.domain.Person;
import com.fastcampus.javaallinone.project3.mycontact.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by mileNote on 2020-09-15
 * Blog : https://milenote.tistory.com
 * Github : https://github.com/SimKyunam
 */
@RequestMapping("/api/person")
@RestController
@Slf4j
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable Long id){
        return personService.getPerson(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postPerson(@RequestBody @Valid PersonDto personDto){
        personService.put(personDto);
    }

    @PutMapping("/{id}")
    public void modifyPerson(@PathVariable Long id, @RequestBody PersonDto person){
        personService.modify(id, person);
    }

    @PatchMapping("/{id}")
    public void modifyPerson(@PathVariable Long id, String name){
        personService.modify(id, name);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id){
        personService.delete(id);
    }
}
