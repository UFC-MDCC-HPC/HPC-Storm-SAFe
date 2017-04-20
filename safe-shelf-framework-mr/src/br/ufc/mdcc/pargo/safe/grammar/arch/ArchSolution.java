package br.ufc.mdcc.pargo.safe.grammar.arch;

import java.util.ArrayList;
import java.util.List;

public class ArchSolution {

	private List<ArchComponent> components;

	public ArchSolution() {
		this.components = new ArrayList<ArchComponent>();
	}

	public List<ArchComponent> getComponents() {
		return components;
	}

	public void setComponents(List<ArchComponent> components) {
		this.components = components;
	}

	public void addArchComponent(ArchComponent comp) {

		this.components.add(comp);
	}

	public ArchComponent getArchComponentByIdComponent(String idComponent) {

		ArchComponent componentDummy = new ArchComponent();
		componentDummy.setIdComponent(idComponent);
		Integer index = this.components.indexOf(componentDummy);
		if (index >= 0) {
			return this.components.get(index);
		}
		return null;
	}

	public ArchAction getArchActionByName(String idComponent,
			String idActionPort, String name) {
		ArchComponent componentDummy = new ArchComponent();
		componentDummy.setIdComponent(idComponent);
		Integer index = this.components.indexOf(componentDummy);
		if (index >= 0) {
			ArchComponent component = this.components.get(index);
			return component.getArchActionByName(idActionPort, name);
		}
		return null;
	}

	@Override
	public String toString() {
		String res = "ArchSolution [components]";
		for (ArchComponent component : components) {
			res += "\n\t" + component;
			res+="\n";
		}
		return res;
	}

}
