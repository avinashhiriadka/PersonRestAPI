package com.embl.restapi.person.repository;

import com.embl.restapi.person.domain.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    Person findByLastName(String lastName);
}
