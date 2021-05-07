package fr.istic.nplouzeau.cartaylor.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

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

public class ConfiguratorTest {
	private Configurator configurator;
	private Category category1;
	private Category category2;
	private Category category3;
	private Category category4;
	private Set<Category> setc1 = new HashSet();
	private Set<Category> setc2 = new HashSet();
	private PartType part1;
	private PartType part2;
	private PartType part3;
	
	
	@BeforeEach
	void setUp() {
		configurator = new ConfiguratorImpl();
		category1 = new CategoryImpl("Engine");
		category2 = new CategoryImpl("Transmission");
		category3 = new CategoryImpl("Exterior");
		category4 = new CategoryImpl("Interior");
		
		setc1.add(category1);
		setc1.add(category2);
		setc1.add(category3);
		setc1.add(category4);
		
		setc2.add(category1);
		setc2.add(category2);
		setc2.add(category3);
		
		part1 = new PartTypeImpl("EG100", category1);
		part2 = new PartTypeImpl("TM5", category2);
		part3 = new PartTypeImpl("XC", category3);
		
	}
	
	@Test
	@DisplayName("getCategoriesTest")
	void testGetCategories() {
		Set<Category> setcat = configurator.getCategories();
		assertNotNull(setcat);
		assertEquals(setcat, setc1);
		assertNotEquals(setcat, setc2);
	}
	
	@Test
	@DisplayName("GetVariants")
	void testGetVariants() {
		Set<PartType> variants = new HashSet<>();
		PartType part11 = new PartTypeImpl("EG100", category1);
		PartType part21 = new PartTypeImpl("EG133", category1);
		PartType part31 = new PartTypeImpl("EG210", category1);
		PartType part41 = new PartTypeImpl("ED110", category1);
		PartType part51 = new PartTypeImpl("ED180", category1);
		PartType part61 = new PartTypeImpl("EH120", category1);
		variants.add(part11);
		variants.add(part21);
		variants.add(part31);
		variants.add(part41);
		
		assertNotEquals(configurator.getVariants(category1), variants);
		variants.add(part51);
		variants.add(part61);
		assertEquals(configurator.getVariants(category1), variants);
	}
	
	@Test
	@DisplayName("GetConfiguration")
	void testGetConfiguration() {
		Configuration config = configurator.getConfiguration();
		assertNotNull(config);
		config.selectPart(part1);
		config = configurator.getConfiguration();
		assertNotNull(config);
		Set<PartType> test = new HashSet<>();
		test.add(part1);
		assertEquals(config.getSelectedParts(), test);
		config.selectPart(part2);
		test.add(part2);
		assertEquals(config.getSelectedParts(), test);
	}

}
