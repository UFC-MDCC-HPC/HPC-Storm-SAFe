package br.ufc.mdcc.pargo.safe.v6.impl;

import br.ufc.mdcc.pargo.safe.v6.ISAFeComponent;
import br.ufc.mdcc.pargo.safe.v6.ISAFePort;

public class SAFePort implements ISAFePort{

	private String id;
	private ISAFeComponent parent;
	
	public SAFePort(ISAFeComponent parent, String id) {
		this.parent = parent;
		this.id = id;
	}
	
	@Override
	public String getId() {
		return id;
	}

	@Override
	public ISAFeComponent getParent() {
		return this.parent;
	}
	
	

}
