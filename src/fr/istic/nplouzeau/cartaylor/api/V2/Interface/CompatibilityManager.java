package fr.istic.nplouzeau.cartaylor.api.V2.Interface;

import java.util.Set;

/**
 * 
 *@author RAKOTOARISOA Tahiriniaina Andrian, MBILIA Maurice
 * 
 * Manage the incompatibilities or requirements of the partTypes
 */
public interface CompatibilityManager extends CompatibilityChecker {

	/**
	 * 
	 * @param reference
	 * @param target incompatible PartType to add to the reference
	 * @return adding incompatible PartType to the reference
	 */
    void addIncompatibilities(PartType reference, Set<PartType> target);

    /**
     * 
     * @param reference
     * @param target
     * @return removing incompatible PartType to reference
     */
    void removeIncompatibility(PartType reference, PartType target);

    /**
     * 
     * @param reference
     * @param target
     * @return adding  required PartType to the reference
     */
    void addRequirements(PartType reference, Set<PartType> target);

    /**
     * 
     * @param reference
     * @param target
     * @return removing required PartType to the reference
     */
    void removeRequirement(PartType reference, PartType target);

}
