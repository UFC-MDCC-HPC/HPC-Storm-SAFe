package br.ufc.mdcc.pargo.safe.grammar.arch;

import java.util.ArrayList;
import java.util.List;

public class ArchComponent implements IArchObject{

	private String name;
	private Integer id;
	private ArchContract contract;
	private List<ArchUses> usesList;
	private List<ArchProvides> providesList;
	private List<ArchTask> taskList;
	
	
	public ArchComponent() {
		this.usesList = new ArrayList<ArchUses>();
		this.providesList = new ArrayList<ArchProvides>();
		this.taskList = new ArrayList<ArchTask>();
	}
	
	public void addUsesPort(ArchUses uses){
		this.usesList.add(uses);
	}
	
	public void addProvidesPort(ArchProvides provides){
		this.providesList.add(provides);
	}
	
	public void addTaskPort(ArchTask task){
		this.taskList.add(task);
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
	
	public ArchContract getContract() {
		return contract;
	}

	public void setContract(ArchContract contract) {
		this.contract = contract;
	}

	public ArchAction getArchActionById(Integer id){
		
		ArchAction action = null;
		
		for(ArchTask task:this.taskList){
			action = task.getArchActionById(id);
			if(action!=null) return action;
		}
		
		for(ArchUses uses:this.usesList){
			action = uses.getArchActionById(id);
			if(action!=null) return action;
		}
		
		for(ArchProvides provides:this.providesList){
			action = provides.getArchActionById(id);
			if(action!=null) return action;
		}
		
		
		return action;
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
		if(contract!=null)
			res += this.contract;
		for(ArchPort port:this.usesList){
			res += "\n\t"+port.toString();
		}
		for(ArchPort port:this.providesList){
			res += "\n\t"+port.toString();
		}
		for(ArchPort port:this.taskList){
			res += "\n\t"+port.toString();
		}
		if(this.contract!=null)
			res+=this.contract;
		return res;
	}
	
	
}
