package com.embl.restapi.person.controller;

import com.embl.restapi.person.domain.Person;
import com.embl.restapi.person.domain.PersonList;
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

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public String add(@RequestBody String requestData){
        ObjectMapper objectMapper = new ObjectMapper();
        PersonList personList;
        try {
                personList = objectMapper.readValue(requestData, PersonList.class);

            List<Person> persons = personList.getPersons();
            if(persons != null){
                persons.forEach(person -> {personService.add(person);});
                return objectMapper.writeValueAsString(persons);
            }

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "Exception processing JSON string";
        }

        return "input string is null";
    }

    @GetMapping(value = "findAll", produces = "application/string")
    @ResponseStatus(HttpStatus.OK)
    public String findAll(){
        List<Person> persons = (List<Person>) personService.findAll();

        StringBuffer buffer = new StringBuffer();
        persons.forEach(person -> {buffer.append(person.toString()+ "\n");});
        return buffer.toString();
    }


    @PostMapping(value = "delete", consumes= "application/json",produces = "application/string")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String delete(@RequestBody String requestData){
        ObjectMapper objectMapper = new ObjectMapper();
        PersonList personList;
        try {
            personList = objectMapper.readValue(requestData, PersonList.class);

            List<Person> persons = personList.getPersons();
            if(persons != null){
                persons.forEach(person -> {personService.delete(person);});
                StringBuffer buffer = new StringBuffer();
                persons.forEach(person -> {buffer.append(person.toString()+ "\n");});
                return buffer.toString();
            }

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "Exception processing JSON string";
        }

        return "input string is null";
    }

    @PostMapping(value = "update", consumes= "application/json",produces = "application/string")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String update(@RequestBody String requestData){
        ObjectMapper objectMapper = new ObjectMapper();
        PersonList personList;
        try {
            personList = objectMapper.readValue(requestData, PersonList.class);

            List<Person> persons = personList.getPersons();
            if(persons != null){
                persons.forEach(person -> {personService.update(person);});
                StringBuffer buffer = new StringBuffer();
                persons.forEach(person -> {buffer.append(person.toString()+ "\n");});
                return buffer.toString();
            }

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "Exception processing JSON string";
        }

        return "input string is null";
    }
}