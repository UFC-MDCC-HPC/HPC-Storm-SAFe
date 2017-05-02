package br.ufc.mdcc.pargo.safe.v6.impl;

import java.util.ArrayList;
import java.util.List;

import br.ufc.mdcc.pargo.safe.v6.ISAFeActionConnection;
import br.ufc.mdcc.pargo.safe.v6.ISAFeAbstractFramework;
import br.ufc.mdcc.pargo.safe.v6.ISAFeBuilderServicePort;
import br.ufc.mdcc.pargo.safe.v6.ISAFeComponent;
import br.ufc.mdcc.pargo.safe.v6.ISAFePort;
import br.ufc.mdcc.pargo.safe.v6.ISAFeServices;
import br.ufc.mdcc.pargo.safe.v6.ISAFeServiceConnection;

public class SAFeFramework implements ISAFeBuilderServicePort,ISAFeAbstractFramework{

	private List<ISAFeActionConnection> actionConnections;
	private List<ISAFeServiceConnection> serviceConnections;
	private List<ISAFeComponent> components;
	
	public SAFeFramework() {
		this.serviceConnections = new ArrayList<ISAFeServiceConnection>();
		this.actionConnections = new ArrayList<ISAFeActionConnection>();
		this.components = new ArrayList<ISAFeComponent>();
	}
	
	@Override
	public ISAFeServices getServices() {
		return new SAFeServices();
	}
	
	public ISAFeComponent createInstance(String componentId){
		ISAFeComponent component = new SAFeComponent();
		component.setServices(this.getServices());
		component.setComponentId(componentId);
		this.components.add(component);
		return component;
	}

	@Override
	public ISAFeServiceConnection connectService(String userId, String userPortId,
			String providerId, String providerPortId) {
		ISAFeServiceConnection connection = new SAFeConnection();
		connection.initializeServiceConnection(providerPortId, userPortId,
				providerId, userId);
		this.serviceConnections.add(connection);
		return connection;
	}

	@Override
	public ISAFeActionConnection connectAction(String masterId,
			String masterActionId, String slaveId,
			String slaveActionId) {
		
		ISAFeActionConnection connection = new SAFeConnection();
		connection.initializeActionConnection(slaveActionId, masterActionId, slaveId, masterId);
		this.actionConnections.add(connection);
		return connection;
	}

	@Override
	public List<String> getComponentIds() {
		List<String> componentIds = new ArrayList<String>();
		for(ISAFeComponent component:this.components)
			componentIds.add(component.getComponentId());
		return componentIds;
	}

	@Override
	public List<String> getUsePortIds(String usesId) {
		ISAFeComponent dummy = new SAFeComponent();
		dummy.setComponentId(usesId);
		Integer index = this.components.indexOf(dummy);
		if(index <= 0) return null;
		ISAFeComponent component = this.components.get(index);
		if(component==null) return null;
		if(component.getServices() == null) return null;
		if(component.getServices().getUsesPortIds()==null) return null;
		return component.getServices().getUsesPortIds();
	}

	@Override
	public List<String> getProviderPortIds(String providerId) {
		ISAFeComponent dummy = new SAFeComponent();
		dummy.setComponentId(providerId);
		Integer index = this.components.indexOf(dummy);
		if(index <= 0) return null;
		ISAFeComponent component = this.components.get(index);
		if(component==null) return null;
		if(component.getServices() == null) return null;
		if(component.getServices().getProvidesPorts()==null) return null;
		List<String> providerIds = new ArrayList<String>();
		for(ISAFePort port:component.getServices().getProvidesPorts())
			providerIds.add(port.getId());
		return providerIds;
	}

	

	@Override
	public ISAFeComponent getComponent(String componentId) {
		ISAFeComponent dummy = new SAFeComponent();
		dummy.setComponentId(componentId);
		Integer index = this.components.indexOf(dummy);
		if(index <= 0) return null;
		ISAFeComponent component = this.components.get(index);
		if(component==null) return null;
		return component;
	}

	@Override
	public List<ISAFeServiceConnection> getServiceConnections(String componentId) {
		ISAFeComponent dummy = new SAFeComponent();
		dummy.setComponentId(componentId);
		Integer index = this.components.indexOf(dummy);
		if(index <= 0) return null;
		ISAFeComponent component = this.components.get(index);
		if(component==null) return null;
		if(component.getServices() == null) return null;
		return component.getServices().get
	}

	@Override
	public List<ISAFeServiceConnection> getActionConnections(String componentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getId() {
		return "safe-framework";
	}

	@Override
	public List<String> getActionPortIdsRegistered(String componentId) {
		SAFeComponent dummy = new SAFeComponent();
		dummy.setComponentId(componentId);
		Integer index = this.components.indexOf(dummy);
		if(index <= 0) return null;
		ISAFeComponent component = this.components.get(index);
		if(component==null) return null;
		if(component.getServices() == null) return null;
		if(component.getServices().getActionPortIdsRegistered()==null) return null;
		return component.getServices().getActionPortIdsRegistered();
	}

	@Override
	public List<String> getActionPortIds(String componentId) {
		ISAFeComponent dummy = new SAFeComponent();
		dummy.setComponentId(componentId);
		Integer index = this.components.indexOf(dummy);
		if(index <= 0) return null;
		ISAFeComponent component = this.components.get(index);
		if(component==null) return null;
		if(component.getServices() == null) return null;
		if(component.getServices().getActionPorts()==null) return null;
		List<String> actionIds = new ArrayList<String>();
		for(ISAFePort port:component.getServices().getActionPorts())
			actionIds.add(port.getId());
		return actionIds;
	}

}
