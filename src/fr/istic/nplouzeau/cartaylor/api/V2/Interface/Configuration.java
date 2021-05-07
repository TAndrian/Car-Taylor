package fr.istic.nplouzeau.cartaylor.api.V2.Interface;


import java.io.PrintStream;
import java.util.Optional;
import java.util.Set;



/**
 * 
 * @author RAKOTOARISOA Tahiriniaina Andrian, MBILIA Maurice
 * 
 * To Build a product
 */
public interface Configuration {

	/**
	 * verify if the configuration is valid
	 * @return true if it is valid, else false
	 */
    boolean isValid();

    /**
     * verify if the configuration is complete
     * @return True if the configuration is complete, else false
     */
    boolean isComplete();

    /**
     * gives the set of the selected parts
     * @return the set of the selected parts
     */
    Set<Part> getSelectedParts();

    /**
     * take the partType corresponding to the ChosenPart 
     * to add it to the configuration
     * @param chosenPart is the part to add
     * 
     */
    void selectPart(PartType chosenPart);

    /**
     * Get the current configuration PartType in the category which was put in the param
     * @param category : the chosen one which u want to see chosen the PartType
     * @return null if nothing was chosen, or the chosen PartType
     */
    Optional<Part> getSelectionForCategory(Category category);

    /**
     * 
     * unselect the part of the configuration with the indicated category
     * @param categoryToClear
     * 
     */
    void unselectPartType(Category categoryToClear);

    /**
     * clearing the configuration : remove all part in the current configuration
     */
    void clear();
    
    /**
     * Extension for the V1
     * @param file : file the file where the description will be print
     * Write an HTML description of the configuration id it's complete and valid
     */
    void printDescription(PrintStream file);
    

}
