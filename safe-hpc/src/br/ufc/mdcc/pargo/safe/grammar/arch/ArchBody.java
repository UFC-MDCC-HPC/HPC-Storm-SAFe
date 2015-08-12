package br.ufc.mdcc.pargo.safe.grammar.arch;

import java.util.ArrayList;
import java.util.List;

public class ArchBody {

	private List<ArchComponent> components;
	
	public ArchBody() {
		this.components = new ArrayList<ArchComponent>();
	}
	
	public void addArchComponent(ArchComponent comp){
		this.components.add(comp);
	}
	
	public ArchComponent getArchComponentById(Integer id){
		System.out.println("SIZE:" +this.components.size());
		ArchComponent ac = new ArchComponent();
		ac.setId(id);
		int indexOf = this.components.indexOf(ac);
		ArchComponent archComponent = this.components.get(indexOf);
		return archComponent;
	}
	
	public ArchAction getArchActionById(Integer id){
		ArchAction action = null;
		for(ArchComponent comp:this.components){
			action = comp.getArchActionById(id);
			if(action!=null) return action;
		}
		return action;
	}
	
	@Override
	public String toString() {
		String res="";
		for(ArchComponent component:components)
			res+="\n"+component;
		return res;
	}
}
