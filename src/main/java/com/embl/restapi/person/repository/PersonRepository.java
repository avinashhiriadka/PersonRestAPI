package com.embl.restapi.person.repository;

import com.embl.restapi.person.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query(value = "SELECT * FROM Person p WHERE p.first_name = :firstname and p.last_name = :lastname",
    nativeQuery = true)
    Person findByName(@Param("firstname") String firstName, @Param("lastname") String lastName);
}
