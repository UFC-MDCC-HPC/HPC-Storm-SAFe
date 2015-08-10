package br.ufc.mdcc.pargo.safe.grammar.arch;

import br.ufc.mdcc.pargo.safe.grammar.arch.contract.ArchInstanceType;

public class ArchContract {

	private Long id;
	private String name;
	private String uri;
	private ArchInstanceType instanceType;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
				+ "]";
	}
	 
}
