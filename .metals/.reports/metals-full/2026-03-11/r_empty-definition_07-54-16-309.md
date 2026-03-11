error id: file:///C:/Users/Yasin/School/software%20testing/Final%20Project/spring-petclinic/src/test/java/org/springframework/samples/petclinic/owner/OwnerTests.java:org/springframework/validation/BeanPropertyBindingResult#
file:///C:/Users/Yasin/School/software%20testing/Final%20Project/spring-petclinic/src/test/java/org/springframework/samples/petclinic/owner/OwnerTests.java
empty definition using pc, found symbol in pc: org/springframework/validation/BeanPropertyBindingResult#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 2396
uri: file:///C:/Users/Yasin/School/software%20testing/Final%20Project/spring-petclinic/src/test/java/org/springframework/samples/petclinic/owner/OwnerTests.java
text:
```scala
package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class OwnerTests {

    @Test
    void addPet_addsNewPet() {
        Owner owner = new Owner();
        Pet pet = new Pet();
        pet.setName("Fluffy");
        owner.addPet(pet);
        assertTrue(owner.getPets().contains(pet));
    }

    @Test
    void getPet_byName() {
        Owner owner = new Owner();
        Pet pet = new Pet();
        pet.setName("Bella");
        owner.addPet(pet);
        assertEquals(pet, owner.getPet("Bella"));
        assertEquals(pet, owner.getPet("bella"));
    }

    @Test
    void toString_containsName() {
        Owner owner = new Owner();
        owner.setFirstName("John");
        owner.setLastName("Doe");
        owner.setAddress("123 Main");
        owner.setCity("Town");
        owner.setTelephone("1234567890");
        String s = owner.toString();
        assertTrue(s.contains("John"));
        assertTrue(s.contains("Doe"));
    }

    @Test
    void owner_setAndGetAddress() {
        Owner owner = new Owner();
        owner.setAddress("456 Elm St");
        assertEquals("456 Elm St", owner.getAddress());
    }

    @Test
    void owner_setAndGetCity() {
        Owner owner = new Owner();
        owner.setCity("Chicago");
        assertEquals("Chicago", owner.getCity());
    }

    @Test
    void owner_setAndGetTelephone() {
        Owner owner = new Owner();
        owner.setTelephone("9876543210");
        assertEquals("9876543210", owner.getTelephone());
    }

    @Test
    void pet_setAndGetType() {
        Pet pet = new Pet();
        PetType type = new PetType();
        type.setName("dog");
        pet.setType(type);
        assertEquals("dog", pet.getType().getName());
    }

    @Test
    void pet_addVisit() {
        Pet pet = new Pet();
        Visit visit = new Visit();
        visit.setDescription("Checkup");
        visit.setDate(LocalDate.now());
        pet.addVisit(visit);
        assertTrue(pet.getVisits().contains(visit));
    }

    @Test
    void petValidator_rejectsBlankName() {
        PetValidator validator = new PetValidator();
        Pet pet = new Pet();
        pet.setName("");
        org.springframework.validation.BeanPrope@@rtyBindingResult errors =
            new org.springframework.validation.BeanPropertyBindingResult(pet, "pet");
        validator.validate(pet, errors);
        assertTrue(errors.hasErrors());
    }

    @Test
    void petValidator_rejectsNullType() {
        PetValidator validator = new PetValidator();
        Pet pet = new Pet();
        pet.setName("Fluffy");
        pet.setType(null);
        pet.setId(null);
        org.springframework.validation.BeanPropertyBindingResult errors =
            new org.springframework.validation.BeanPropertyBindingResult(pet, "pet");
        validator.validate(pet, errors);
        assertTrue(errors.hasErrors());
    }

}
```


#### Short summary: 

empty definition using pc, found symbol in pc: org/springframework/validation/BeanPropertyBindingResult#