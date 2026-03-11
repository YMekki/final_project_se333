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

}