error id: file:///C:/Users/Yasin/School/software%20testing/Final%20Project/spring-petclinic/src/test/java/org/springframework/samples/petclinic/model/ModelTests.java:_empty_/Pet#getBirthDate#
file:///C:/Users/Yasin/School/software%20testing/Final%20Project/spring-petclinic/src/test/java/org/springframework/samples/petclinic/model/ModelTests.java
empty definition using pc, found symbol in pc: _empty_/Pet#getBirthDate#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 1054
uri: file:///C:/Users/Yasin/School/software%20testing/Final%20Project/spring-petclinic/src/test/java/org/springframework/samples/petclinic/model/ModelTests.java
text:
```scala
package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.owner.Pet;
import org.springframework.samples.petclinic.owner.PetType;
import org.springframework.samples.petclinic.owner.Visit;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ModelTests {

    @Test
    void baseEntity_setAndGetId() {
        Pet pet = new Pet();
        pet.setId(42);
        assertEquals(42, pet.getId());
        assertTrue(pet.isNew() == false);
    }

    @Test
    void newEntity_isNew() {
        Pet pet = new Pet();
        assertTrue(pet.isNew());
    }

    @Test
    void pet_setAndGetName() {
        Pet pet = new Pet();
        pet.setName("Whiskers");
        assertEquals("Whiskers", pet.getName());
    }

    @Test
    void pet_setAndGetBirthDate() {
        Pet pet = new Pet();
        LocalDate date = LocalDate.of(2020, 1, 1);
        pet.setBirthDate(date);
        assertEquals(date, pet.ge@@tBirthDate());
    }

    @Test
    void petType_setAndGetName() {
        PetType type = new PetType();
        type.setName("cat");
        assertEquals("cat", type.getName());
    }

    @Test
    void visit_setAndGetDescription() {
        Visit visit = new Visit();
        visit.setDescription("Annual checkup");
        assertEquals("Annual checkup", visit.getDescription());
    }

    @Test
    void visit_defaultDate_isToday() {
        Visit visit = new Visit();
        assertEquals(LocalDate.now(), visit.getDate());
    }

    @Test
    void namedEntity_setAndGetName() {
        PetType type = new PetType();
        type.setName("dog");
        assertEquals("dog", type.getName());
        assertTrue(type.toString().contains("dog"));
    }

}
```


#### Short summary: 

empty definition using pc, found symbol in pc: _empty_/Pet#getBirthDate#