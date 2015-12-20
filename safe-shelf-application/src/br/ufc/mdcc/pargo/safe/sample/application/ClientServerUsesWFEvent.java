package br.ufc.mdcc.pargo.safe.sample.application;

import br.ufc.mdcc.pargo.safe.framework.port.HShelfUsesPort;
import br.ufc.mdcc.pargo.safe.framework.port.dflt.HShelfWorkflowEventPort;
import br.ufc.mdcc.pargo.safe.framework.port.event.IHShelfWorkflowEventListener;

public class ClientServerUsesWFEvent extends HShelfUsesPort{

	public void addWorkflowEventListener(IHShelfWorkflowEventListener listener){
		((HShelfWorkflowEventPort)this.providesPort).addWorkflowEventListener(listener);
	}
}
