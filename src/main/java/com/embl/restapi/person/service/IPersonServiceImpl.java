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
        personRepository.findByLastName(person.getLastName());
    }

    @Override
    public boolean delete(Person person) {
        return false;
    }
}
