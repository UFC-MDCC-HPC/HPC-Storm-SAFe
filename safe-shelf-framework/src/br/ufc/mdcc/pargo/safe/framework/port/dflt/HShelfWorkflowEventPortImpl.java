package br.ufc.mdcc.pargo.safe.framework.port.dflt;

import java.util.ArrayList;
import java.util.List;

import br.ufc.mdcc.pargo.safe.framework.port.event.HShelfEventType;
import br.ufc.mdcc.pargo.safe.framework.port.event.HShelfWorkflowEvent;
import br.ufc.mdcc.pargo.safe.framework.port.event.IHShelfWorkflowEventListener;
import br.ufc.mdcc.pargo.safe.framework.util.HShelfConsoleLogger;

public class HShelfWorkflowEventPortImpl extends HShelfWorkflowEventPort{

	private List<IHShelfWorkflowEventListener> workflowListeners;
	
	public HShelfWorkflowEventPortImpl() {
		HShelfConsoleLogger.write("Creating HShelfEventHandler");
		this.workflowListeners = new ArrayList<IHShelfWorkflowEventListener>();
	}
	
	public void addWorkflowEventListener(IHShelfWorkflowEventListener listener){
		this.workflowListeners.add(listener);
	}
	
	public void notifyAllWorkflowListeners(HShelfWorkflowEvent event){
		for(IHShelfWorkflowEventListener listener:this.workflowListeners){
			listener.workflowActivity(event);
		}
	}
	
	public void setMessage(String message){
		HShelfWorkflowEvent event = 
				new HShelfWorkflowEvent(HShelfEventType.Message, message);
		this.notifyAllWorkflowListeners(event);
	}
}
