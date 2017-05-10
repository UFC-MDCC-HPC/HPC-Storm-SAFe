package br.ufc.mdcc.pargo.safe.v6.impl;

import br.ufc.mdcc.pargo.safe.v6.ISAFeActionFuture;
import br.ufc.mdcc.pargo.safe.v6.ISAFeComponent;
import br.ufc.mdcc.pargo.safe.v6.ISAFeTaskPort;

public class SAFeLifeCycle extends SAFeGoPort implements ISAFeTaskPort{

	public SAFeLifeCycle(ISAFeComponent parent, String id) {
		super(parent, id);
	}

	@Override
	public void invoke(String actionId) {
		System.out.println("LC: "+this.getParent().getComponentId()+":"+this.getId()+":"+actionId);
		
	}

	@Override
	public void invoke(String actionId, ISAFeActionFuture actionFuture) {
		// TODO Auto-generated method stub
		
	}
	
	

}
