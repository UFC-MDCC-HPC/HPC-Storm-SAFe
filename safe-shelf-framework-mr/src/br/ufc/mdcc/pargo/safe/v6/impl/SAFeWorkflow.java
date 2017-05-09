package br.ufc.mdcc.pargo.safe.v6.impl;

import br.ufc.mdcc.pargo.safe.grammar.ISAFeSWLFlowParser;

public class SAFeWorkflow extends SAFeGenericComponent{
	
	private ISAFeSWLFlowParser flow;

	public void setFlow(ISAFeSWLFlowParser flow) {
		this.flow = flow;
	}

}
