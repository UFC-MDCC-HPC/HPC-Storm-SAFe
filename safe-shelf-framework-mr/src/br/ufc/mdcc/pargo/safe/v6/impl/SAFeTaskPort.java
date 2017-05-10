package br.ufc.mdcc.pargo.safe.v6.impl;

import br.ufc.mdcc.pargo.safe.v6.ISAFeActionFuture;
import br.ufc.mdcc.pargo.safe.v6.ISAFeComponent;
import br.ufc.mdcc.pargo.safe.v6.ISAFeTaskPort;

public class SAFeTaskPort extends SAFePort implements ISAFeTaskPort{

	public SAFeTaskPort(ISAFeComponent parent, String id) {
		super(parent, id);
	}

	@Override
	public void invoke(String actionId) {
		
		System.out.println("USUAL: "+this.getParent().getComponentId()+":"+this.getId()+":"+actionId);
		
	}

	@Override
	public void invoke(String actionId, ISAFeActionFuture actionFuture) {
		// TODO Auto-generated method stub
		
	}

	 
}
