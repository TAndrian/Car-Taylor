package fr.istic.nplouzeau.cartaylor.api.V2.Interface;

import java.io.PrintStream;

/**
 * 
 * @author RAKOTOARISOA Tahiriniaina Andrian, MBILIA Maurice
 * 
 * A public type that represent the partType
 *
 */

public interface PartType {
	
	/**
	 * 
	 * @return the current name of the partType
	 */
    String getName();

    /**
     * 
     * @return the category corresponding to the current partType
     */
    Category getCategory();
    
    /**
     * Extension for the V1
     * @param file : file the file where the description will be print
     * Write an HTML description of the configuration id it's complete and valid
     */

	void printDescription(PrintStream file);

}
