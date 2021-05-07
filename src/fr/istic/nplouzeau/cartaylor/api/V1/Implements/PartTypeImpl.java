package fr.istic.nplouzeau.cartaylor.api.V1.Implements;

import java.io.PrintStream;

import fr.istic.nplouzeau.cartaylor.api.V1.Interface.Category;
import fr.istic.nplouzeau.cartaylor.api.V1.Interface.PartType;

/**
 * 
 * @author RAKOTOARISOA Tahiriniaina Andrian, MBILIA Maurice
 *
 */
public class PartTypeImpl implements PartType {

	private String partName;
	private Category category;

	public PartTypeImpl(String name, Category c) {
		this.category = c;
		this.partName = name;
	}

	@Override
	public String getName() {

		return this.partName;
	}

	@Override
	public Category getCategory() {

		return this.category;
	}

	@Override
	public void printDescription(PrintStream file) {
		file.print("<p> Categorie : " +  this.getCategory().getName() + ", part : " + getName() + "</p>");
		
	}


}
