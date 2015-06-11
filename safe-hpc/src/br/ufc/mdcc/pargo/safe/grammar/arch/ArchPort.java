package br.ufc.mdcc.pargo.safe.grammar.arch;

import java.util.List;

public class ArchPort {

	private String name;
	private Integer id;
	private List<ArchAction> actions;
	
	public ArchPort(){
		this.name = "";
	}
	
	public ArchPort(String name) {
		
		this.name = name;
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
	
	public List<ArchAction> getActions() {
		return actions;
	}

	public void setActions(List<ArchAction> actions) {
		this.actions = actions;
	}

	@Override
	public boolean equals(Object obj) {
		
		if(!(obj instanceof ArchPort)) return false;
		
		ArchPort port = (ArchPort)obj;
		if(port.getId().intValue()!=this.getId().intValue())
			return false;

		return true;
	}

	@Override
	public String toString() {
		String res;
		res = "ArchPort [name=" + name + ", id=" + id + "]";
		if(this.actions!=null)
		for(ArchAction action:this.actions)
			res+="\n\t\t"+action;
		return res;
		
	}
	
}
