package fr.istic.nplouzeau.cartaylor.api.V2.Interface;

public interface Part extends PropertyManager {
	default String getName() {
		return this.getClass().getTypeName();
	}
	
	Category getCategory();
	PartType getType();

}
