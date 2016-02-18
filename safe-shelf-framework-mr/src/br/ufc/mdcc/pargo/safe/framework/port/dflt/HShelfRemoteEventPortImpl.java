package br.ufc.mdcc.pargo.safe.framework.port.dflt;

import java.util.ArrayList;
import java.util.List;

import br.ufc.mdcc.pargo.safe.framework.port.event.HShelfRemoteEvent;
import br.ufc.mdcc.pargo.safe.framework.port.event.IHShelfRemoteEventListener;

public class HShelfRemoteEventPortImpl extends HShelfRemoteEventPort{

	private List<IHShelfRemoteEventListener> remoteListeners;
	
	public HShelfRemoteEventPortImpl() {
		this.remoteListeners = new ArrayList<IHShelfRemoteEventListener>();
	}
	
	@Override
	public void addWorkflowEventListener(IHShelfRemoteEventListener listener) {
		this.addWorkflowEventListener(listener);
		
	}

	@Override
	public void notifyAllWorkflowListeners(HShelfRemoteEvent event) {
		for(IHShelfRemoteEventListener listener:remoteListeners){
			listener.remoteActivity(event);
		}
		
	}

}
