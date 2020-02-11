package com.embl.restapi.person.controller;

import com.embl.restapi.person.domain.Person;
import com.embl.restapi.person.service.IPersonService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
class PersonController {

    private IPersonService personService;

    @Autowired
    public PersonController(IPersonService service){
        this.personService = service;
    }

    @GetMapping(value = "/")
    public List<Person> findAll(){
        return (List<Person>) personService.findAll();
    }

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public String add(@RequestBody String personList){
        ObjectMapper objectMapper = new ObjectMapper();
        List<Person> persons;
        try {
                persons = objectMapper.readValue(personList, new TypeReference<List<Person>>() {
            });

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "Exception processing JSON string";
        }
        if(personList != null){
            persons.forEach(person -> {personService.add(person);});
            return persons.toString();
        }
        return "input string is null";
    }

}