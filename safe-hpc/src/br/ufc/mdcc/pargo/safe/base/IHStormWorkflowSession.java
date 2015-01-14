package br.ufc.mdcc.pargo.safe.base;

import br.ufc.mdcc.pargo.safe.exception.HStormWorkflowCreationException;
import br.ufc.mdcc.pargo.safe.port.IHStormPort;

public interface IHStormWorkflowSession {

	public HStormWorkflowSAFeSWL getWorkflow() throws HStormWorkflowCreationException;
	public IHStormPort getUserPort();
	public void setUserPort(IHStormPort port);
}
