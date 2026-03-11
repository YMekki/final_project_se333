package org.springframework.samples.petclinic.vet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VetTests {

	@Test
	void addSpecialty_addsToVet() {
		Vet vet = new Vet();
		Specialty s = new Specialty();
		s.setName("dentistry");
		vet.addSpecialty(s);
		assertTrue(vet.getSpecialties().contains(s));
		assertEquals(1, vet.getNrOfSpecialties());
	}

	@Test
	void getSpecialties_isSorted() {
		Vet vet = new Vet();
		Specialty s1 = new Specialty();
		s1.setName("radiology");
		Specialty s2 = new Specialty();
		s2.setName("dentistry");
		vet.addSpecialty(s1);
		vet.addSpecialty(s2);
		assertEquals("dentistry", vet.getSpecialties().get(0).getName());
	}

	@Test
	void vet_withNoSpecialties() {
		Vet vet = new Vet();
		assertEquals(0, vet.getNrOfSpecialties());
		assertTrue(vet.getSpecialties().isEmpty());
	}

}