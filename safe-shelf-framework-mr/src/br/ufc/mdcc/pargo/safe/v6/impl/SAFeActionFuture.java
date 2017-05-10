package br.ufc.mdcc.pargo.safe.v6.impl;

import br.ufc.mdcc.pargo.safe.v6.ISAFeActionFuture;

public class SAFeActionFuture implements ISAFeActionFuture{

	Integer value;
	
	@Override
	public Integer getValue() {
		return value;
	}

	@Override
	public void setValue(Integer value) {
		this.value = value;
	}

	
}
