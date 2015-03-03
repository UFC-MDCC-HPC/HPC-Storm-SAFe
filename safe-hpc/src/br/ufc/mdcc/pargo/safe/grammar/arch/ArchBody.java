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
	
	@Override
	public String toString() {
		String res="";
		for(ArchComponent component:components)
			res+="\n"+component;
		return res;
	}
}
