package fr.istic.nplouzeau.cartaylor.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import fr.istic.nplouzeau.cartaylor.api.V1.Interface.*;
import fr.istic.nplouzeau.cartaylor.api.V1.Implements.*;

/**
 * 
 * @author RAKOTOARISOA Tahiriniaina Andrian, MBILIA Maurice
 *
 */

public class CompatibilityManagerTest {
	Set<PartType> SelectedPart = new HashSet<>();
	CompatibilityManager cm;
	Category category1 = new CategoryImpl("Engine");
	Category category2 = new CategoryImpl("Transmission");
	PartType part11 = new PartTypeImpl("EG100", category1);
	PartType part21 = new PartTypeImpl("EH120", category1);
	PartType part12 = new PartTypeImpl("TA5", category2);
	PartType part22 = new PartTypeImpl("TC120", category2);

	@BeforeEach
	void setUp() {
		SelectedPart.add(part11);
		SelectedPart.add(part21);
		SelectedPart.add(part12);
		SelectedPart.add(part22);

		cm = new CompatibilityManagerImpl(SelectedPart);
	}
	
	@Test
	@DisplayName("addrequirementTest & addincompatibilities : user story 5")
	void addrequirement_addincompatibilitiesTest() {
		Set<PartType> setTest = new HashSet<>();
		PartType test = new PartTypeImpl("TA5", category2);
		PartType test2 = new PartTypeImpl("TC120", category2);

		setTest.add(test);
		setTest.add(test2);

		
		cm.addRequirements(part12, setTest);
		assertNotEquals(cm.getRequirements(part11), setTest); //should not add if it's the same category
		
		cm.addIncompatibilities(part11, setTest); //EG100 not compatible with TA5
		cm.addRequirements(part21, setTest); // EH120 requirement for TC120
		
		assertEquals(cm.getRequirements(part21), setTest);
		assertEquals(cm.getIncompatibilities(part11), setTest);
	}
	
	@Test
	@DisplayName("removeincompatibilities : user Story 5")
	void removeincompatibilities() {
		Set<PartType> setTest = new HashSet<>();
		setTest.add(part12);
		cm.addIncompatibilities(part11, setTest);//EG100 not compatible with TA5
		cm.removeIncompatibility(part11, part12);
		assertEquals(cm.getIncompatibilities(part11), new HashSet<>());	
	}
	
	@Test
	@DisplayName("removerequirements : user Story 5")
	void removerequirements() {
		Set<PartType> setTest = new HashSet<>();
		setTest.add(part12);
		cm.addRequirements(part21, setTest); //TH120 required for TC120
		cm.removeIncompatibility(part21, part12);
		assertEquals(cm.getIncompatibilities(part21), new HashSet<>());
	}
	
}
