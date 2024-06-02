package com.unittest.codecoverage.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.unittest.codecoverage.models.Person;

import static org.junit.jupiter.api.Assertions.*;

public class PersonRepositoryTest {

    private PersonRepository repository;

    @BeforeEach
    public void setUp() {
        repository = new PersonRepository();
    }

    @Test
    public void testInsertPerson() {
        Person person = new Person();
        person.setName("Felix");
        person.setAge(7);
        Person p = repository.insert(person);
        assertEquals(person, p);
    }


    @Test
    public void testGetPerson() {
        String name = "Felix";
        Person result = repository.get(name);
        assertNull(result);
    }


    @Test
    public void testUpdatePerson() {
        Person person = new Person();
        person.setName("Felix");
        person.setAge(7);

        Person p = repository.insert(person);
        p.setName("Feli");
        p.setAge(8);
        assertDoesNotThrow(() -> repository.update(p));
    }

    @Test
    public void testDelete_shouldDeletePersonSuccessfullyWhenNameIsNotNull() {
        assertDoesNotThrow(() -> repository.delete("Felix"));
    }
}
