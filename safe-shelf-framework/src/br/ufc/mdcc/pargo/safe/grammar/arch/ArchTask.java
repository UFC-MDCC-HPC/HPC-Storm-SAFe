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

	public List<ArchAction> getActions() {
		return actions;
	}

	 
	
	public ArchAction getArchActionById(Integer id){
		
		ArchAction action = new ArchAction();
		action.setId(id);
		
		
		int indexOf =  this.actions.indexOf(action);
		if(indexOf>=0)
			return this.actions.get(indexOf);
		return null;
	}
	
	@Override
	public String toString() {
		String res = "ArchTask "+this.getName()+"-"+this.getId()+" :\n";
		for(ArchAction action:actions){
			res += "\t\t"+action;
			res += "\n";
		}
		return res;
	}
}
