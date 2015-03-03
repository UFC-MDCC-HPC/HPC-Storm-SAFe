package br.ufc.mdcc.pargo.safe.grammar.arch;

public class ArchAttachment {

	private ArchUses uses;
	private ArchProvides provides;
	
	
	public ArchUses getUses() {
		return uses;
	}
	public void setUses(ArchUses uses) {
		this.uses = uses;
	}
	public ArchProvides getProvides() {
		return provides;
	}
	public void setProvides(ArchProvides provides) {
		this.provides = provides;
	}
	
	@Override
	public String toString() {
		String res="";
		res+="\n"+this.uses;
		res+="\n"+this.provides;
		return res;
	}
}
