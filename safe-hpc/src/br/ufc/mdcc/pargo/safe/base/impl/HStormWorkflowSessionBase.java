package br.ufc.mdcc.pargo.safe.base.impl;

import br.ufc.mdcc.pargo.safe.base.HStormWorkflowSAFeSWL;
import br.ufc.mdcc.pargo.safe.base.IHStormWorkflowSession;
import br.ufc.mdcc.pargo.safe.exception.HStormWorkflowCreationException;
import br.ufc.mdcc.pargo.safe.port.IHStormPort;

public class HStormWorkflowSessionBase implements IHStormWorkflowSession {

	@Override
	public HStormWorkflowSAFeSWL getWorkflow() throws HStormWorkflowCreationException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IHStormPort getUserPort() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setUserPort(IHStormPort port) {
		// TODO Auto-generated method stub
		
	}

}
