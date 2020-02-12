package com.embl.restapi.person.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class PersonList implements Serializable {
   @JsonProperty("person")
    private List<Person> persons;

    @JsonProperty("person")
    public List<Person> getPersons() {
        return persons;
    }

    @JsonProperty("person")
    public void setPersons(List<Person> personList){
        this.persons = personList;
    }


}
