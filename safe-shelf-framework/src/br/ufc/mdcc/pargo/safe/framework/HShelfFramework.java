package br.ufc.mdcc.pargo.safe.framework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.ufc.mdcc.pargo.safe.application.HShelfApplication;
import br.ufc.mdcc.pargo.safe.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.port.HShelfBuilderService;
import br.ufc.mdcc.pargo.safe.port.HShelfPort;
import br.ufc.mdcc.pargo.safe.port.event.HShelfConnectionEvent;
import br.ufc.mdcc.pargo.safe.port.event.HShelfEventHandler;
import br.ufc.mdcc.pargo.safe.port.event.HShelfEventType;
import br.ufc.mdcc.pargo.safe.port.event.IHShelfConnectionEventListener;
import br.ufc.mdcc.pargo.safe.services.HShelfServiceImpl;
import br.ufc.mdcc.pargo.safe.services.IHShelfService;
import br.ufc.mdcc.pargo.safe.util.HShelfConsoleLogger;
import br.ufc.mdcc.pargo.safe.workflow.HShelfWorkflow;

public class HShelfFramework extends HShelfBuilderService{

	
	private Map<String,HShelfPort> providesPortMap;
	private Map<String, Object> usesPortTypeMap;
	private Map<String,HShelfComponent> componentMap;
	
	private HShelfWorkflow workflow;
	private HShelfApplication application;
	private HShelfEventHandler eventHandler;
	
	public HShelfFramework() {
		HShelfConsoleLogger.write("Creating HShelfFramework");
		this.providesPortMap = new HashMap<String,HShelfPort>();
		this.usesPortTypeMap = new HashMap<String, Object>();
		this.componentMap = new HashMap<String,HShelfComponent>();
		this.eventHandler = new HShelfEventHandler();
	}
	
	public void initialize(HShelfApplication application){
		this.application = application;
		
		//workflow
		this.workflow = new HShelfWorkflow(this.application.getName()+"-worflow",this);
		IHShelfService serviceWf = new HShelfServiceImpl();
		serviceWf.initialize(this, this.workflow);
		this.workflow.setServices(serviceWf);
		
		//application
		IHShelfService serviceApp = new HShelfServiceImpl();
		serviceApp.initialize(this, this.application);
		this.application.setServices(serviceApp);
		
		//adding
		this.addComponent(this.workflow);
		this.addComponent(this.application);
		
	}
	
	@Override
	public HShelfComponent createComponent(String name, String className) {
		HShelfComponent component = null;
		try {
			component = (HShelfComponent)Class.forName(className).newInstance();
			component.setName(name);
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
		if(!component.hasServices()){
			IHShelfService serviceImpl = new HShelfServiceImpl();
			serviceImpl.initialize(this, component); 
			component.setServices(serviceImpl);
		}
		if(component instanceof IHShelfConnectionEventListener){
			this.addConnectionEventListener((IHShelfConnectionEventListener)component);
		}
		HShelfConsoleLogger.write("Component "+component.getName()+" added");
	}
	
	public void addProvidesPort(HShelfPort port){
		this.providesPortMap.put(port.getName(),port);
		if(port instanceof IHShelfConnectionEventListener){
			this.addConnectionEventListener((IHShelfConnectionEventListener)port);
		}
		
		HShelfConnectionEvent event = new HShelfConnectionEvent(HShelfEventType.ProvidesAdded, port);
		this.notifyAllConnectionListeners(event);
	}
	
	public void addUsesPortType(String name, Object type){
		this.usesPortTypeMap.put(name, type);
	}
	
	public Object getUsesPort(String name){
		return this.usesPortTypeMap.get(name);
	}
	
	public HShelfPort getProvidesPort(String name){
		return this.providesPortMap.get(name);
	}
	
	//Events
	public void addConnectionEventListener(IHShelfConnectionEventListener listener){
		this.eventHandler.addConnectionEventListener(listener);
	}
	
	public void notifyAllConnectionListeners(HShelfConnectionEvent event){
		this.eventHandler.notifyAllConnectionListeners(event);
	}
}
