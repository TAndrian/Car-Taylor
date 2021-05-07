package fr.istic.nplouzeau.cartaylor.api.V1.Implements;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import fr.istic.nplouzeau.cartaylor.api.V1.Interface.Category;
import fr.istic.nplouzeau.cartaylor.api.V1.Interface.CompatibilityManager;
import fr.istic.nplouzeau.cartaylor.api.V1.Interface.Configuration;
import fr.istic.nplouzeau.cartaylor.api.V1.Interface.PartType;

/**
 * 
 * @author RAKOTOARISOA Tahiriniaina Andrian, MBILIA Maurice
 *
 */
public class ConfigurationImpl implements Configuration {

	private Set<PartType> selectPart = new HashSet<>(); // the part in the configuration
	private CompatibilityManager compatibilityMg;
	private Set<Category> categories; // all possible categories

	public ConfigurationImpl(Set<Category> allcategories, CompatibilityManager comp, Set<PartType> parts) {
		this.categories = allcategories;
		this.compatibilityMg = comp;
		this.selectPart = parts;

	}

	@Override
	public boolean isValid() {
		Set<PartType> incompatibilities;
		Set<PartType> requirements;

		for (PartType p1 : this.selectPart) {
			incompatibilities = this.compatibilityMg.getIncompatibilities(p1);
			requirements = this.compatibilityMg.getRequirements(p1);

			// Check out if there are incompatibilities in the current part
			for (PartType p2 : incompatibilities) {
				if (this.selectPart.contains(p2)) {
					return false;
				}
			}

			// Check out if there are requirements in the current part
			for (PartType p3 : requirements) {
				if (!this.selectPart.contains(p3)) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public boolean isComplete() {
		Iterator<PartType> it = this.selectPart.iterator();
		Set<Category> cat = new HashSet<>();

		while (it.hasNext()) {
			PartType p = it.next();

			// Check if the category is present for each part
			if (!categories.contains(p.getCategory())) {
				return false;
			}
			cat.add(p.getCategory());

		}
		// Check if there are 4 different categories
		if (cat.size() != 4) {
			return false;
		}

		return true;
	}

	@Override
	public Set<PartType> getSelectedParts() {
		return this.selectPart;
	}

	@Override
	public void selectPart(PartType chosenPart) {
		this.selectPart.add(chosenPart);

	}

	@Override
	public PartType getSelectionForCategory(Category category) {
		Iterator<PartType> it = selectPart.iterator();

		while (it.hasNext()) {
			PartType p = it.next();
			if (p.getCategory().equals(category)) {
				return p;
			}
		}
		return null;
	}

	@Override
	public void unselectPartType(Category categoryToClear) {
		Iterator<PartType> it = selectPart.iterator();

		while (it.hasNext()) {
			PartType p = it.next();
			if (p.getCategory().equals(categoryToClear)) {
				it.remove();
			}
		}
	}

	@Override
	public void clear() {
		this.selectPart.clear();
	}

	@Override
	public void printDescription(PrintStream file) {
		if (isComplete() && isValid()) {
			file.print("< !DOCTYPE html>\n" + "<html>\n" + "<head>\n" + "<title> Configuration description </title>\n"
					+ "</head>\n" + "<body>\n");

			for (PartType p : this.selectPart) {
				p.printDescription(file);
			}
			file.print("</body>\n" + "</html>");

		}

	}
}
