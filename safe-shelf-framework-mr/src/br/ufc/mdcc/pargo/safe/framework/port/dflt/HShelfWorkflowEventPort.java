package br.ufc.mdcc.pargo.safe.framework.port.dflt;

import br.ufc.mdcc.pargo.safe.framework.port.HShelfProvidesPort;
import br.ufc.mdcc.pargo.safe.framework.port.event.HShelfWorkflowEvent;
import br.ufc.mdcc.pargo.safe.framework.port.event.IHShelfWorkflowEventListener;

public abstract class HShelfWorkflowEventPort extends HShelfProvidesPort{

	public abstract void addWorkflowEventListener(IHShelfWorkflowEventListener listener);
	public abstract void notifyAllWorkflowListeners(HShelfWorkflowEvent event);
	
}
