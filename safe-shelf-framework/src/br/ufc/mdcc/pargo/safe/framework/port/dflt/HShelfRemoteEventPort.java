package br.ufc.mdcc.pargo.safe.framework.port.dflt;

import br.ufc.mdcc.pargo.safe.framework.port.HShelfPort;
import br.ufc.mdcc.pargo.safe.framework.port.event.HShelfRemoteEvent;
import br.ufc.mdcc.pargo.safe.framework.port.event.IHShelfRemoteEventListener;

public abstract class HShelfRemoteEventPort extends HShelfPort{

	public abstract void addWorkflowEventListener(IHShelfRemoteEventListener listener);
	public abstract void notifyAllWorkflowListeners(HShelfRemoteEvent event);
}
