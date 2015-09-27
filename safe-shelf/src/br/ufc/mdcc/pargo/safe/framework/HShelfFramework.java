package br.ufc.mdcc.pargo.safe.framework;

import java.util.ArrayList;
import java.util.List;

import br.ufc.mdcc.pargo.safe.application.HShelfApplication;
import br.ufc.mdcc.pargo.safe.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.port.HShelfProvidesPort;
import br.ufc.mdcc.pargo.safe.port.HShelfUsesPort;
import br.ufc.mdcc.pargo.safe.port.dflt.HShelfBuilderService;
import br.ufc.mdcc.pargo.safe.port.event.HShelfEventHandler;
import br.ufc.mdcc.pargo.safe.port.event.HShelfEventType;
import br.ufc.mdcc.pargo.safe.port.event.IHShelfConnectionEventListener;
import br.ufc.mdcc.pargo.safe.services.IHShelfService;
import br.ufc.mdcc.pargo.safe.workflow.HShelfWorkflow;

public class HShelfFramework extends HShelfBuilderService{

	private List<HShelfUsesPort> usesPortList;
	private List<HShelfProvidesPort> providesPortList;
	private List<HShelfComponent> componentList;
	
	private HShelfWorkflow workflow;
	private HShelfApplication application;
	private HShelfEventHandler eventHandler;
	
	public HShelfFramework() {
		this.usesPortList = new ArrayList<HShelfUsesPort>();
		this.providesPortList = new ArrayList<HShelfProvidesPort>();
		this.componentList = new ArrayList<HShelfComponent>();
		this.eventHandler = new HShelfEventHandler();
	}
	
	public void initialize(HShelfApplication application){
		this.application = application;
		this.workflow = new HShelfWorkflow(this.application.getName()+"-worflow");
		this.addComponent(this.application);
		this.addComponent(this.workflow);
	}
	
	@Override
	public HShelfConnection connect(HShelfComponent user, String userPortName,
			HShelfComponent providerComponent, String providerPortName) {
		this.eventHandler.notifyAllConnectionListeners(HShelfEventType.ConnectPending);
		// TODO Auto-generated method stub
		this.eventHandler.notifyAllConnectionListeners(HShelfEventType.Connected);
		return null;
	}

	@Override
	public void disconnect(HShelfConnection conn) {
		this.eventHandler.notifyAllConnectionListeners(HShelfEventType.DisconnectPending);
		// TODO Auto-generated method stub
		this.eventHandler.notifyAllConnectionListeners(HShelfEventType.Diconnected);
	}

	@Override
	public HShelfComponent createComponent(String instanceName, String className) {
		HShelfComponent component = null;
		try {
			component = (HShelfComponent)Class.forName(instanceName).newInstance();
			component.setName(instanceName);
			this.componentList.add(component);
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
		this.componentList.add(component);
		return component;
	}
	
	@Override
	public HShelfComponent getComponent(String instanceName) {
		//silly...
		HShelfComponent ref = new HShelfComponent() {
			@Override
			public void setServices(IHShelfService services) {}
		};
		ref.setName(instanceName);
		int index = this.componentList.indexOf(ref);
		if(index>=0)
			return this.componentList.get(index);
		return null;
	}

	@Override
	public List<HShelfComponent> getComponents() {
		return this.componentList;
	}

	@Override
	public List<HShelfProvidesPort> getProvidesPort() {
		return this.providesPortList;
	}

	@Override
	public List<HShelfUsesPort> getUsesPort() {
		return this.usesPortList;
	}

	public void addComponent(HShelfComponent component){
		this.componentList.add(component);
		if(component instanceof IHShelfConnectionEventListener){
			this.addConnectionEventListener((IHShelfConnectionEventListener)component);
		}
	}
	
	public void addProvidesPort(HShelfProvidesPort port){
		this.providesPortList.add(port);
		if(port instanceof IHShelfConnectionEventListener){
			this.addConnectionEventListener((IHShelfConnectionEventListener)port);
		}
	}
	
	public void addUsesPort(HShelfUsesPort port){
		this.usesPortList.add(port);
		if(port instanceof IHShelfConnectionEventListener){
			this.addConnectionEventListener((IHShelfConnectionEventListener)port);
		}
	}
	
	public void addConnectionEventListener(IHShelfConnectionEventListener listener){
		this.eventHandler.addConnectionEventListener(listener);
	}
}
