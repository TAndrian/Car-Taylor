package fr.istic.nplouzeau.cartaylor.api.V2.Interface;

import java.util.Set;

/**
 * 
 * @author RAKOTOARISOA Tahiriniaina Andrian, MBILIA Maurice
 * 
 * Verify if the PartType needs a specific PartType or has incompatibilities of PartType
 *
 */
public interface CompatibilityChecker {

	/**
	 * 
	 * @param reference
	 * @return Give all incompatible PartType of reference
	 */
	Set<PartType> getIncompatibilities(PartType reference);

	/**
	 * 
	 * @param reference
	 * @return Give all require PartType with reference
	 * 
	 */
	Set<PartType> getRequirements(PartType reference);

}
