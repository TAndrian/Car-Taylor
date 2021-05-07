package fr.istic.nplouzeau.cartaylor.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
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

public class ConfigurationTest {

	private Configuration config;
	private CompatibilityManager cm;
	private Configurator configtr = new ConfiguratorImpl();
	private Set<PartType> allpart = new HashSet<>();
	private Set<Category> allcategories = new HashSet<>();
	Category category1 = new CategoryImpl("Engine");
	Category category2 = new CategoryImpl("Transmission");
	Category category3 = new CategoryImpl("Exterior");
	Category category4 = new CategoryImpl("Interior");

	PartType part11 = new PartTypeImpl("EG100", category1);
	PartType part21 = new PartTypeImpl("ED180", category1);
	PartType part31 = new PartTypeImpl("EH120", category1);

	PartType part12 = new PartTypeImpl("TC120", category2);
	PartType part22 = new PartTypeImpl("TA5", category2);

	PartType part13 = new PartTypeImpl("XC", category3);
	PartType part14 = new PartTypeImpl("IN", category4);
	PartType part24 = new PartTypeImpl("IH", category4);

	@BeforeEach
	void setUp() {
		allcategories.add(category1);
		allcategories.add(category2);
		allcategories.add(category3);
		allcategories.add(category4);

		Set<PartType> selectPart = new HashSet<>();
		selectPart.add(part12);
		Set<PartType> selectPart2 = new HashSet<>();
		selectPart.add(part22);

		allpart.add(part11);
		allpart.add(part21);
		allpart.add(part31);
		allpart.add(part12);
		allpart.add(part13);
		allpart.add(part14);
		allpart.add(part24);

		cm = new CompatibilityManagerImpl(allpart);
		cm.addRequirements(part31, selectPart);
		cm.addIncompatibilities(part11, selectPart2);
		config = new ConfigurationImpl(configtr.getCategories(), cm, allpart);
	}

	@Test
	@DisplayName("User story 3 : testIsValid")
	void testIsValid() {
		config.selectPart(part11);
		assertFalse(config.isValid());
		config.selectPart(part12);
		assertTrue(config.isValid());
	}

	@Test
	@DisplayName("testIsComplete")
	void isCompleteTest() {
		config.selectPart(part11);
		config.selectPart(part12);
		config.selectPart(part13);
		config.selectPart(part14);
		assertTrue(config.isComplete());
	}

	@Test
	@DisplayName("testSelectedPartTest")
	void getselectedPartTest() {
		assertNotNull(config.getSelectedParts());
		config.selectPart(part11);
		config.selectPart(part21);
		assertNotNull(config.getSelectedParts());
	}

	@Test
	@DisplayName("testGetSelectionForCategory")
	void testGetSelectionForCategory() {
		assertNotNull(config.getSelectionForCategory(category1));
		config.selectPart(part11);
		assertEquals(part11, config.getSelectionForCategory(category1));
	}

	@Test
	@DisplayName("user Story 4 : unselectedPartTest")
	void unselectedPartTest() {
		config.selectPart(part11);
		assertNotNull(config.getSelectedParts());
		config.selectPart(part21);
		config.selectPart(part22);
		config.unselectPartType(category1);
		assertTrue(config.getSelectedParts().contains(part22));
		assertTrue(!config.getSelectedParts().contains(part11) && !config.getSelectedParts().contains(part21));
	}

	@Test
	@DisplayName("clearTest")
	void clearTest() {
		config.selectPart(part11);
		assertNotNull(config.getSelectedParts());
		config.clear();
		assertNull(config.getSelectedParts());
	}
	
	@Test
	@DisplayName("html : userStory6")
	void htmlDesc() throws FileNotFoundException {
		config.selectPart(part11);
		config.selectPart(part12);
		config.selectPart(part13);
		config.selectPart(part14);
		File file=new File("file.html");
        FileOutputStream fileOutputStream=new FileOutputStream(file);
        PrintStream printStream=new PrintStream(fileOutputStream);
        config.printDescription(printStream);
		
	}

}
