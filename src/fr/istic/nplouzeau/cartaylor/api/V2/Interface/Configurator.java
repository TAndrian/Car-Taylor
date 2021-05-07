package fr.istic.nplouzeau.cartaylor.api.V2.Interface;

import java.util.Set;

/**
 * 
 * @author RAKOTOARISOA Tahiriniaina Andrian, MBILIA Maurice
 * 
 * 
 */
public interface Configurator {
    
	/**
	 * 
	 * @return a set of categories of the configuration
	 */
    Set<Category> getCategories();
    
    /**
     * Gives all part of category
     * @param category
     * @return return a set of PartType of the category
     */
    Set<PartType> getVariants(Category category);
    
    /**
     * 
     * @return the current configuration 
     */
    Configuration getConfiguration();

    /**
     * 
     * @return the compatibilityChecker
     */
    CompatibilityChecker getCompatibilityChecker();
    
   

}
