package br.ufc.mdcc.pargo.safe.grammar.arch;

public class ArchAction {

	private Integer id;
	private String name;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String nome) {
		this.name = nome;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof ArchAction))
			return false;
		ArchAction actionTemp = (ArchAction)obj;
		if(this.id.intValue()==actionTemp.id.intValue()) return true;
		return false;
	}
	
	@Override
	public String toString() {
		return "ArchAction [name=" + name + ", id=" + id + "]";
	}
	
}
