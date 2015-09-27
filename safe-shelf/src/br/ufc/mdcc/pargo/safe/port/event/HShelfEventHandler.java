package br.ufc.mdcc.pargo.safe.port.event;

import java.util.ArrayList;
import java.util.List;

public class HShelfEventHandler {

	private List<IHShelfConnectionEventListener> connectionListeners;
	
	public HShelfEventHandler() {
		this.connectionListeners = new ArrayList<IHShelfConnectionEventListener>();
	}
	
	public void addConnectionEventListener(IHShelfConnectionEventListener listener){
		this.connectionListeners.add(listener);
	}
	
	public void notifyAllConnectionListeners(HShelfEventType eventType){
		for(IHShelfConnectionEventListener listener:this.connectionListeners){
			listener.connectionActivity(eventType);
		}
	}
}
