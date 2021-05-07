package fr.istic.nplouzeau.cartaylor.api.V2.Implements;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import fr.istic.nplouzeau.cartaylor.api.V2.Interface.Category;
import fr.istic.nplouzeau.cartaylor.api.V2.Interface.CompatibilityManager;
import fr.istic.nplouzeau.cartaylor.api.V2.Interface.Configuration;
import fr.istic.nplouzeau.cartaylor.api.V2.Interface.Configurator;
import fr.istic.nplouzeau.cartaylor.api.V2.Interface.PartType;
/**
 * 
 * @author RAKOTOARISOA Tahiriniaina Andrian, MBILIA Maurice
 *
 */
public class ConfiguratorImpl implements Configurator {

	private Set<Category> setCategories = new HashSet<>();
	private Set<PartType> setparts = new HashSet<>();
	private Configuration configuration;
	private CompatibilityManager compMg;
	
	
	public ConfiguratorImpl() {
		init();	
		compMg = new CompatibilityManagerImpl(setparts);
		configuration = new ConfigurationImpl(setCategories, compMg, setparts);
		
	}
	
	public void init() {
		
		
		Category category1 = new CategoryImpl("Engine");
		Category category2 = new CategoryImpl("Transmission");
		Category category3= new CategoryImpl("Exterior");
		Category category4 = new CategoryImpl("Interior");
		
		this.setCategories.add(category1);
		this.setCategories.add(category2);
		this.setCategories.add(category3);
		this.setCategories.add(category4);
		
		/*---------------------------------------------------*/
		/*PartType for Engine*/
		PartType part1 = new PartTypeImpl("EG100", category1);
		PartType part2 = new PartTypeImpl("EG133", category1);
		PartType part3 = new PartTypeImpl("EG210", category1);
		PartType part4 = new PartTypeImpl("ED110", category1);
		PartType part5 = new PartTypeImpl("EG180", category1);
		PartType part6 = new PartTypeImpl("EH120", category1);
		
		/*PartType for Transmission*/
		PartType part7 = new PartTypeImpl("TM5", category2);
		PartType part8 = new PartTypeImpl("TM6", category2);
		PartType part9 = new PartTypeImpl("TA5", category2);
		PartType part10 = new PartTypeImpl("TS6", category2);
		PartType part11 = new PartTypeImpl("TSF7", category2);
		PartType part12 = new PartTypeImpl("TC120", category2);
		
		/*PartType for Exterior*/
		PartType part13 = new PartTypeImpl("XC", category3);
		PartType part14 = new PartTypeImpl("XM", category3);
		PartType part15 = new PartTypeImpl("XS", category3);
		
		/*PartType for Interior*/
		PartType part16 = new PartTypeImpl("IN", category4);
		PartType part17 = new PartTypeImpl("IM", category4);
		PartType part18 = new PartTypeImpl("IS", category4);
		
		this.setparts.add(part1);
		this.setparts.add(part2);
		this.setparts.add(part3);
		this.setparts.add(part4);
		this.setparts.add(part5);
		this.setparts.add(part6);
		this.setparts.add(part7);
		this.setparts.add(part8);
		this.setparts.add(part9);
		this.setparts.add(part10);
		this.setparts.add(part11);
		this.setparts.add(part12);
		this.setparts.add(part13);
		this.setparts.add(part14);
		this.setparts.add(part15);
		this.setparts.add(part16);
		this.setparts.add(part17);
		this.setparts.add(part18);
	}
	
	
	@Override
	public Set<Category> getCategories() {
		
		return this.setCategories;
	}

	@Override
	public Set<PartType> getVariants(Category category) {
		Set<PartType> variant = new HashSet<>();
		Iterator<PartType> it = this.setparts.iterator();
		
		while(it.hasNext()) {
			PartType p = it.next();
			if(p.getCategory().equals(category)) {
				variant.add(p);
			}
		}
		return variant;
	}

	@Override
	public Configuration getConfiguration() {
		return this.configuration;
	}

	@Override
	public CompatibilityChecker getCompatibilityChecker() {
		return this.compMg;
	}

}
