package br.ufc.mdcc.pargo.safe.grammar.arch;

import java.util.ArrayList;
import java.util.List;

public class ArchTask extends ArchPort {

	private List<ArchAction> actions;
	
	public ArchTask() {
		this.actions = new ArrayList<ArchAction>();
	}
	
	public void addArchAction(ArchAction action){
		this.actions.add(action);
	}
	
	public List<ArchAction> getActions(){
		return this.actions;
	}
	
	@Override
	public String toString() {
		String res = "ArchTask:\n";
		for(ArchAction action:actions){
			res += action;
			res += "\n";
		}
		return res;
	}
}
