package com.embl.restapi.person.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name="Person")
@Access(value=AccessType.PROPERTY)
public class Person {
  //  private static final long serialVersionUID = 1L;

    private Long id;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("age")
    private Integer age;

    @JsonProperty("favourite_colour")
    private String favouriteColour;

    @JsonProperty("hobby")
    private List<String> hobbies;

    public Person(){}

    public Person(String first, String last, int age) {
        this.firstName = first;
        this.lastName = last;
        this.age = age;
    }

    @Id
    @Column(name="person_id",unique = true, nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotEmpty
    @Column(name="first_name")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("first_name")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @NotEmpty
    @Column(name="last_name")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("last_name")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

  //  @NotEmpty
    @Column(name="age")
    public Integer getAge() {
        return age;
    }

    @JsonProperty("age")
    public void setAge(Integer age) {
        this.age = age;
    }

    @Column(name="colour")
    public String getFavouriteColour() {
        return favouriteColour;
    }

    @JsonProperty("favourite_colour")
    public void setFavouriteColour(String favouriteColour) {
        this.favouriteColour = favouriteColour;
    }

    @ElementCollection
    @Column(name="hobbies")
    public List<String> getHobbies() {
        return hobbies;
    }

    @JsonProperty("hobby")
    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString(){
        return "Person [First Name=" + firstName + ", Last Name =" + lastName + ", Age=" + age
                + ", Favourite Colour=" + favouriteColour + ",Hobbies=" + hobbies;
    }
}
