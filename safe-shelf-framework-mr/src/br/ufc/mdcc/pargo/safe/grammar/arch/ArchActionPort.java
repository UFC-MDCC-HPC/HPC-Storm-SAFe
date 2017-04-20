package br.ufc.mdcc.pargo.safe.grammar.arch;

import java.util.ArrayList;
import java.util.List;

public class ArchActionPort extends ArchPort {

	private List<ArchAction> actions;

	public ArchActionPort() {
		this.actions = new ArrayList<ArchAction>();
	}

	public void addArchAction(ArchAction action) {
		this.actions.add(action);
	}

	public List<ArchAction> getActions() {
		return actions;
	}

	public ArchAction getArchActionByName(String name) {

		ArchAction action = new ArchAction();
		action.setName(name);

		int indexOf = this.actions.indexOf(action);
		if (indexOf >= 0)
			return this.actions.get(indexOf);
		return null;
	}

	@Override
	public String toString() {
		String res = "ArchActionPort [idPort=" + idPort +  ", idComponent=" + idComponent+"]";
		for (ArchAction action : actions) {
			res += "\n\t" + action.toString();
		}
		return res;
	}

}
