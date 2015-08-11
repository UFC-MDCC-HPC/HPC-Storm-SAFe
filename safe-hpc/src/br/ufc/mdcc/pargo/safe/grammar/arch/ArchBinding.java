package br.ufc.mdcc.pargo.safe.grammar.arch;

public class ArchBinding implements IArchObject{

	protected Integer id;
	protected String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		
		return "[id="+id+", name="+name+"]";
	}
	
}
