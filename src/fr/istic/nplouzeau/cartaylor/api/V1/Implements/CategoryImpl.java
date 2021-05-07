package fr.istic.nplouzeau.cartaylor.api.V1.Implements;

import fr.istic.nplouzeau.cartaylor.api.V1.Interface.Category;

/**
 * 
 * @author RAKOTOARISOA Tahiriniaina Andrian, MBILIA Maurice
 *
 */

public class CategoryImpl implements Category {

	private String CategoryName;

	public CategoryImpl(String name) {
		this.CategoryName = name;
	}

	@Override
	public String getName() {
		return this.CategoryName;
	}

}
