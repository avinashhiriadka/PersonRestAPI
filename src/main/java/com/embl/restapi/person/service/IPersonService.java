package com.embl.restapi.person.service;

import com.embl.restapi.person.domain.Person;

public interface IPersonService {
Iterable<Person> findAll();
void add(Person person);
void update(Person person);
void delete(Person person);

}
