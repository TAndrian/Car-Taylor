package fr.istic.nplouzeau.cartaylor.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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

public class CategoryTest {
	private Category category;
	
	@BeforeEach
	void setUp() throws Exception{
		category = new CategoryImpl("Engine");
	}
	
	@Test
	@DisplayName("Check the name of the category")
	void getNameTest() {
		assertEquals("Engine", category.getName());
	}
	
	@Test
	@DisplayName("Check if 2 categories are the same category")
	void CategoryEqualityTest() {
		Category c1 = new CategoryImpl("Engine");
		Category c2 = new CategoryImpl("Transmission");
		Category c3 = new CategoryImpl("Exterior");
		
		assertEquals(c1,c1);
		assertNotEquals(c1, c2);
		assertNotEquals(c3, c2);

	}

}
