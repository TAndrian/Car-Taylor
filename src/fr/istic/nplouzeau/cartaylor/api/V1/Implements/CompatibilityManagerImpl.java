package fr.istic.nplouzeau.cartaylor.api.V1.Implements;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;

import fr.istic.nplouzeau.cartaylor.api.V1.Interface.CompatibilityManager;
import fr.istic.nplouzeau.cartaylor.api.V1.Interface.PartType;

/**
 * 
 * @author RAKOTOARISOA Tahiriniaina Andrian, MBILIA Maurice
 *
 */

public class CompatibilityManagerImpl implements CompatibilityManager {

	private Map<String, Set<PartType>> requirements = new HashMap<>();
	private Map<String, Set<PartType>> incompatibilities = new HashMap<>();
	public Set<PartType> allPart;

	public CompatibilityManagerImpl(Set<PartType> parts) {
		this.allPart = parts;
		init();
	}

	public void init() {
		Iterator<PartType> it = allPart.iterator();
		while (it.hasNext()) {
			PartType p = it.next();
			this.incompatibilities.put(p.getName(), new HashSet<>());
			this.requirements.put(p.getName(), new HashSet<>());
		}
	}

	@Override
	public Set<PartType> getIncompatibilities(PartType reference) {
		return this.incompatibilities.get(reference.getName());
	}

	@Override
	public Set<PartType> getRequirements(PartType reference) {
		return this.requirements.get(reference.getName());
	}

	@Override
	public void addIncompatibilities(PartType reference, Set<PartType> target) {

		Iterator<PartType> it = target.iterator();
		while (it.hasNext()) {
			PartType p = it.next();
			if (!this.requirements.get(reference.getName()).contains(p) && !this.requirements.get(p.getName()).contains(reference)) {
				if (!reference.getCategory().equals(p.getCategory())) {
					this.incompatibilities.get(reference.getName()).add(p);
				}

			}
		}
	}

	@Override
	public void removeIncompatibility(PartType reference, PartType target) {
		Set<PartType> set = this.incompatibilities.get(reference.getName());
		if (set.contains(target)) {
			set.remove(target);
			incompatibilities.remove(target.getName()).remove(reference);
		}
	}

	@Override
	public void addRequirements(PartType reference, Set<PartType> target) {
		Iterator<PartType> it = target.iterator();
		while (it.hasNext()) {
			PartType p = it.next();
			if (!(this.incompatibilities.get(reference.getName()).contains(p))) {
				if (!reference.getCategory().equals(p.getCategory())) {
					this.requirements.get(reference.getName()).add(p);
				}
			}
		}

	}

	@Override
	public void removeRequirement(PartType reference, PartType target) {
		Set<PartType> set = this.requirements.get(reference.getName());
		if (set.contains(target)) {
			set.remove(target);
			requirements.remove(target.getName()).remove(reference);
		}
	}
}
