package com.unittest.codecoverage.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PersonTest {

    @Test
    public void testAge() {
        Person person = new Person();
        person.setAge(7);
        assertEquals(person.getAge(), 7);
    }
}