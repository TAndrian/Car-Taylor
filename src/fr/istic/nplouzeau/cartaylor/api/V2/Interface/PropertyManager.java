package fr.istic.nplouzeau.cartaylor.api.V2.Interface;

import java.util.Optional;
import java.util.Set;

public interface PropertyManager {
	/**
	 * Returns an immutable set of the property names supported by the property manager.
	 * @return
	 */
	public Set<String> getPropertyNames();
	
	/**
	 * Returns the immutable set of discrete string values for a given property.
	 * For properties that have anon explicit set of possible values (egdouble converted to strings),
	 * or for a non existing property name, returns an empty set.
	 * 
	 * @param propertyName a non-null string reference
	 * @return an immutable set (see above)
	 */
	public Set<String> getAvailablePropertyValues(String propertyName);
	
	
	/**
	 * Returns the optional value of a property.
	 * If the object does not support that property then an empty optional is returned.
	 * @param propertyName the property to read
	 * @return
	 */
	public Optional<String> getProperty(String propertyName);
	
	/**
	 * Sets the value of a given property.
	 * If there is not such property, or if it not writable, or if the value is invalid
	 * then an IllegalArgumentException is thrown.
	 * 
	 * @param propertyName
	 * @param propertyValue
	 * @throwsIllegalArgumentException  (see above)
	 */
	void setProperty(String propertyName, String propertyValue);

}
