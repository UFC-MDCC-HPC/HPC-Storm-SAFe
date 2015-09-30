package br.ufc.mdcc.pargo.safe.port.event;

import java.util.ArrayList;
import java.util.List;

import br.ufc.mdcc.pargo.safe.util.HShelfConsoleLogger;

public class HShelfEventHandler {

	private List<IHShelfConnectionEventListener> connectionListeners;
	
	public HShelfEventHandler() {
		HShelfConsoleLogger.write("Creating HShelfEventHandler");
		this.connectionListeners = new ArrayList<IHShelfConnectionEventListener>();
	}
	
	public void addConnectionEventListener(IHShelfConnectionEventListener listener){
		this.connectionListeners.add(listener);
	}
	
	public void notifyAllConnectionListeners(HShelfConnectionEvent event){
		for(IHShelfConnectionEventListener listener:this.connectionListeners){
			listener.connectionActivity(event);
		}
	}
}
