package br.ufc.mdcc.pargo.safe.grammar.arch;

import br.ufc.mdcc.pargo.safe.grammar.arch.contract.ArchInstanceType;

public class ArchContract implements IArchObject{

	private Integer id;
	private String name;
	private String uri;
	private ArchInstanceType instanceType;
	
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
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public ArchInstanceType getInstanceType() {
		return instanceType;
	}
	public void setInstanceType(ArchInstanceType instanceType) {
		this.instanceType = instanceType;
	}
	@Override
	public String toString() {
		return "ArchContract [id=" + id + ", name=" + name + ", uri=" + uri
				+ "]"; /*+
				"\nTYPE: "+this.instanceType;*/
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof ArchContract))
			return false;
		
		ArchContract ref = (ArchContract)obj;
		if(ref.getId().longValue()==this.id.longValue()) return true;
		return false;
	}
	 
}
