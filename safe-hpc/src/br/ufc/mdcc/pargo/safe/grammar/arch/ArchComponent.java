package br.ufc.mdcc.pargo.safe.grammar.arch;

import java.util.ArrayList;
import java.util.List;

public class ArchComponent {

	private String name;
	private Integer id;
	private List<ArchUses> usesList;
	private List<ArchProvides> providesList;
	
	public ArchComponent() {
		this.usesList = new ArrayList<ArchUses>();
		this.providesList = new ArrayList<ArchProvides>();
	}
	
	public void addUsesPort(ArchUses uses){
		this.usesList.add(uses);
	}
	
	public void addProvidesPort(ArchProvides provides){
		this.providesList.add(provides);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(!(obj instanceof ArchComponent)) return false;
		ArchComponent comp = (ArchComponent)obj;
		if(comp.getId().intValue()!=this.getId().intValue()) return false;
		return true;
	}

	@Override
	public String toString() {
		String res = "ArchComponent [name=" + name + ", id=" + id + "]";
		for(ArchPort port:this.usesList){
			res += "\n\t"+port.toString();
		}
		for(ArchPort port:this.providesList){
			res += "\n\t"+port.toString();
		}
		return res;
	}
	
	
}