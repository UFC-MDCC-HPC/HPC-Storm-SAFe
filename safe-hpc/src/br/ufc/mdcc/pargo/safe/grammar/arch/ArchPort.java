package br.ufc.mdcc.pargo.safe.grammar.arch;

public class ArchPort {

	private String name;
	private Integer id;
	
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
		return "ArchPort [name=" + name + ", id=" + id + "]";
	}
	
}
