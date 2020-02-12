package com.embl.restapi.person;

import com.embl.restapi.person.domain.Person;
import com.embl.restapi.person.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest
class PersonApplicationTests {

	@Autowired
	private PersonRepository personRepository;

	@Test
	public void whenFindingCustomerByLastName_thenCorrect() {
		personRepository.save(new Person("John", "Miller", 39));
		assertThat(personRepository.findByLastName("Miller")).isInstanceOf(Person.class);
	}

	@Test
	public void whenFindingAllCustomers_thenCorrect(){
		personRepository.save(new Person("John", "Miller", 39));
		personRepository.save(new Person("Arthur", "Betty", 49));
		assertThat(personRepository.findAll()).isInstanceOf(List.class);

	}

	@Test
	public void whenSavingPerson_thenCorrect(){
		personRepository.save(new Person("John", "Miller", 39));
		Person person = personRepository.findById(1L).orElseGet(() -> new Person("Arthur", "Betty", 49));
		assertThat(person.getLastName()).isEqualTo("Miller");
	}

}
