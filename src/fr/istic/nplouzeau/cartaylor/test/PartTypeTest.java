package fr.istic.nplouzeau.cartaylor.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

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

public class PartTypeTest {
	private PartType part11, part21, part13, part14;
	private Category category1, category2, category3, category4;
	
	@BeforeEach
	void setUp() {
		category1 = new CategoryImpl("Engine");
		category2 = new CategoryImpl("Transmission");
		category3 = new CategoryImpl("Exterior");
		category4 = new CategoryImpl("Interior");
		
		part11 = new PartTypeImpl("EG100", category1);
		part21 = new PartTypeImpl("ED180", category1);
		part13 = new PartTypeImpl("XC", category3);
		part14 = new PartTypeImpl("IS", category4);
		
	}
	
	@Test
	@DisplayName("testGetName")
	void testGetName(){
		assertEquals("EG100", part11.getName());
		assertNotEquals(part21.getName(), part11.getName());
	}
	
	@Test
	@DisplayName("testGetCategory")
	void testCategory() {
		assertEquals(part11.getCategory(), part21.getCategory());
		assertNotEquals(part11.getCategory(), part13.getCategory());
	}
	
	@Test
	@DisplayName("testEqualityOfPartTypes")
	void testEqual() {
		PartType test = new PartTypeImpl("EG100", category1);
		assertTrue(part11.equals(test));
		assertFalse(part13.equals(test));
	}
}
