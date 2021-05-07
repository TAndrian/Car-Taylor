package fr.istic.nplouzeau.cartaylor.api.V2.Implements;

import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.istic.nplouzeau.cartaylor.api.V2.Interface.Category;
import fr.istic.nplouzeau.cartaylor.api.V2.Interface.PartType;

/**
 * 
 * @author RAKOTOARISOA Tahiriniaina Andrian, MBILIA Maurice
 *
 */
public class PartTypeImpl implements PartType {

	private String partName;
	private Class<? extends PartImpl> classRef;
	private Category category;

	public PartTypeImpl(String name, Class<? extends PartImpl> classRef, Category c) {
		this.partName = name;
		this.classRef = classRef;
		this.category = c;
	}

	public PartImpl newInstance() {
		Constructor<? extends PartImpl> constructor;
		try {
			constructor = classRef.getConstructor();
			return constructor.newInstance();
		} catch (Exception e) {
			Logger.getGlobal().log(Level.SEVERE, "constructor call failled", e);
			System.exit(-1);
		}
		return null;
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
		file.print("<p> Categorie : " + this.getCategory().getName() + ", part : " + getName() + "</p>");

	}

}
