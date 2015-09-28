package br.ufc.mdcc.pargo.safe.framework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.ufc.mdcc.pargo.safe.application.HShelfApplication;
import br.ufc.mdcc.pargo.safe.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.port.HShelfPort;
import br.ufc.mdcc.pargo.safe.port.dflt.HShelfBuilderService;
import br.ufc.mdcc.pargo.safe.port.event.HShelfEventHandler;
import br.ufc.mdcc.pargo.safe.port.event.HShelfEventType;
import br.ufc.mdcc.pargo.safe.port.event.IHShelfConnectionEventListener;
import br.ufc.mdcc.pargo.safe.services.HShelfServiceImpl;
import br.ufc.mdcc.pargo.safe.services.IHShelfService;
import br.ufc.mdcc.pargo.safe.util.HShelfConsoleLogger;
import br.ufc.mdcc.pargo.safe.workflow.HShelfWorkflow;

public class HShelfFramework extends HShelfBuilderService{

	
	private Map<String,HShelfPort> providesPortMap;
	private Map<String,HShelfComponent> componentMap;
	
	private HShelfWorkflow workflow;
	private HShelfApplication application;
	private HShelfEventHandler eventHandler;
	
	public HShelfFramework() {
		HShelfConsoleLogger.write("Creating HShelfFramework");
		this.providesPortMap = new HashMap<String,HShelfPort>();
		this.componentMap = new HashMap<String,HShelfComponent>();
		this.eventHandler = new HShelfEventHandler();
	}
	
	public void initialize(HShelfApplication application){
		this.application = application;
		this.workflow = new HShelfWorkflow(this.application.getName()+"-worflow");
		IHShelfService serviceApp = new HShelfServiceImpl();
		IHShelfService serviceWf = new HShelfServiceImpl();
		this.application.setServices(serviceApp);
		this.workflow.setServices(serviceWf);
		serviceApp.initialize(this, this.application);
		serviceWf.initialize(this, this.workflow);
		this.addComponent(this.application);
		this.addComponent(this.workflow);
		
		this.workflow.initialize();
	}
	
	@Override
	public HShelfConnection connect(HShelfComponent user, String userPortName,
			HShelfComponent provider, String providerPortName) {
		this.notifyAllConnectionListeners(HShelfEventType.ConnectPending);
		// TODO Auto-generated method stub
		this.notifyAllConnectionListeners(HShelfEventType.Connected);
		return null;
	}

	@Override
	public void disconnect(HShelfConnection conn) {
		this.notifyAllConnectionListeners(HShelfEventType.DisconnectPending);
		// TODO Auto-generated method stub
		this.notifyAllConnectionListeners(HShelfEventType.Diconnected);
	}

	@Override
	public HShelfComponent createComponent(String name, String className) {
		HShelfComponent component = null;
		try {
			component = (HShelfComponent)Class.forName(className).newInstance();
			component.setName(name);
			this.componentMap.put(name,component);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.addComponent(component);
		return component;
	}
	
	@Override
	public HShelfComponent getComponent(String name) {
		 return this.componentMap.get(name);
	}

	@Override
	public List<HShelfComponent> getComponents() {
		List<HShelfComponent> list = new ArrayList<HShelfComponent>();
		for(HShelfComponent component:this.componentMap.values())
			list.add(component);
		return list;
	}

	@Override
	public List<HShelfPort> getProvidesPort() {
		List<HShelfPort> list = new ArrayList<HShelfPort>();
		for(HShelfPort port:this.providesPortMap.values())
			list.add(port);
		return list;
	}

	 

	public void addComponent(HShelfComponent component){
		this.componentMap.put(component.getName(),component);
		if(component instanceof IHShelfConnectionEventListener){
			this.addConnectionEventListener((IHShelfConnectionEventListener)component);
		}
	}
	
	public void addProvidesPort(HShelfPort port){
		this.providesPortMap.put(port.getName(),port);
		if(port instanceof IHShelfConnectionEventListener){
			this.addConnectionEventListener((IHShelfConnectionEventListener)port);
		}
		this.notifyReleaseComponents(port.getName());
	}
	
	
	public HShelfPort getProvidesPort(String name){
		return this.providesPortMap.get(name);
	}
	
	//Events
	public void addConnectionEventListener(IHShelfConnectionEventListener listener){
		this.eventHandler.addConnectionEventListener(listener);
	}
	
	public void notifyAllConnectionListeners(HShelfEventType eventType){
		this.eventHandler.notifyAllConnectionListeners(eventType);
	}
	
	//Semaphores
	private void notifyReleaseComponents(String name){
		
		for(HShelfComponent component:this.getComponents()){
			IHShelfService service = component.getServices();
			if(service.notifySemaphoreRelease(name))
				return;
		}
	}
}
