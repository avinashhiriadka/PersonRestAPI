package com.embl.restapi.person.service;

import com.embl.restapi.person.domain.Person;
import com.embl.restapi.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IPersonServiceImpl implements IPersonService {

private PersonRepository personRepository;
    @Autowired
    public IPersonServiceImpl(PersonRepository personRepository){
        this.personRepository = personRepository;
    }
    @Override
    public Iterable<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public void add(Person person) {
        personRepository.save(person);
    }

    @Override
    public void update(Person person) {
        Person person_old = personRepository.findByName(person.getFirstName(),person.getLastName());
        person.setId(person_old.getId());
        personRepository.save(person);
    }

    @Override
    public void delete(Person person) {
        Person person_old = personRepository.findByName(person.getFirstName(),person.getLastName());
        person.setId(person_old.getId());
        personRepository.delete(person);
    }
}
