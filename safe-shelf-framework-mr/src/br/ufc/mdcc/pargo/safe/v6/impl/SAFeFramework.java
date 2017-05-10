package br.ufc.mdcc.pargo.safe.v6.impl;

import java.util.ArrayList;
import java.util.List;

import br.ufc.mdcc.pargo.safe.grammar.ISAFeSWLArcherParser;
import br.ufc.mdcc.pargo.safe.grammar.ISAFeSWLFlowParser;
import br.ufc.mdcc.pargo.safe.grammar.SAFeSWLArchParser;
import br.ufc.mdcc.pargo.safe.grammar.SAFeSWLFlowParser;
import br.ufc.mdcc.pargo.safe.v6.ISAFeAbstractFramework;
import br.ufc.mdcc.pargo.safe.v6.ISAFeActionConnection;
import br.ufc.mdcc.pargo.safe.v6.ISAFeBuilderServicePort;
import br.ufc.mdcc.pargo.safe.v6.ISAFeComponent;
import br.ufc.mdcc.pargo.safe.v6.ISAFePort;
import br.ufc.mdcc.pargo.safe.v6.ISAFeServiceConnection;
import br.ufc.mdcc.pargo.safe.v6.ISAFeServices;
import br.ufc.mdcc.pargo.safe.v6.ISAFeTaskPort;

public class SAFeFramework implements ISAFeBuilderServicePort,ISAFeAbstractFramework{

	private List<ISAFeActionConnection> actionConnections;
	private List<ISAFeServiceConnection> serviceConnections;
	private List<ISAFeComponent> components;
	private SAFeApplication safeApplication;
	private SAFeWorkflow safeWorkflow;
	private ISAFeSWLArcherParser archParser;
	
	public SAFeFramework(SAFeApplication application) {
		this.serviceConnections = new ArrayList<ISAFeServiceConnection>();
		this.actionConnections = new ArrayList<ISAFeActionConnection>();
		this.components = new ArrayList<ISAFeComponent>();
		
		this.safeApplication = application;
		this.safeApplication.setServices(new SAFeServices());
		this.safeApplication.setComponentId("application");
		
		this.safeWorkflow = new SAFeWorkflow();
		this.safeWorkflow.setServices(new SAFeServices());
		this.safeWorkflow.setComponentId("workflow");
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
		return this.serviceConnections;
	}

	@Override
	public List<ISAFeActionConnection> getActionConnections(String componentId) {
		return this.actionConnections;
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

	@Override
	public void loadArchitecturalLanguageFile(String pathToFile) {
		this.archParser = new SAFeSWLArchParser(pathToFile);
		Architecture2SAFeComponentUtil.archApplication2SAFeComponent(this.archParser, this.safeApplication);
		this.components.add(this.safeApplication);
		Architecture2SAFeComponentUtil.archWorkflow2SAFeComponent(this.archParser,this.safeWorkflow, this);
		this.components.add(this.safeWorkflow);
		Architecture2SAFeComponentUtil.archComponent2SAFeComponentList(this.archParser, this.components, this.safeWorkflow, this);
		Architecture2SAFeComponentUtil.archServiceConnection2SAFeServiceConnectionList(this.archParser, this);
		Architecture2SAFeComponentUtil.archActionConnection2SAFeActionConnectionList(this.archParser, this);
		 
	}

	@Override
	public void loadOrchestrationLanguageFile(String pathToFile) {
		ISAFeSWLFlowParser flow = new SAFeSWLFlowParser(pathToFile);
		flow.setISAFeSWLArcherParser(this.archParser);
		this.safeWorkflow.setFlow(flow);
		this.safeWorkflow.setSAFeFramework(this);
	}

	private ISAFePort findProviderServiceSAFePortFromUsesPort(String usesId, String usesPortId){
	
		for(ISAFeServiceConnection serviceConn:this.serviceConnections){
			if(serviceConn.getUserComponentId().equals(usesId) && serviceConn.getUserPortId().equals(usesPortId)){
				String providerId = serviceConn.getProviderComponentId();
				String providerPortId = serviceConn.getProviderPortId();
				for(ISAFeComponent component: this.components){
					if(component.getComponentId().equals(providerId)){
						for(ISAFePort port:component.getServices().getProvidesPorts()){
							if(port.getId().equals(providerPortId))
								return port;
						}
					}
				}
			}
		}
		return null;
	}
	
	private List<ISAFeTaskPort> findProviderActionSAFePortFromMasterPort(String masterId, String portId){
		//System.out.println(masterId+"-"+portId);
		List<ISAFeTaskPort> res = new ArrayList<ISAFeTaskPort>();
		//System.out.println(actionConnections.size());
		for(ISAFeActionConnection actionConn:this.actionConnections){
			if(actionConn.getMasterComponentId().equals(masterId) && actionConn.getMasterActionPortId().equals(portId)){
				String slaveId = actionConn.getSlaveComponentId();
				String slavePortId = actionConn.getSlaveActionPortId();
				//System.out.println(slaveId+":"+slavePortId);
				//System.out.println(this.components.size());
				for(ISAFeComponent component: this.components){
					//System.out.println(slaveId+":"+component.getComponentId());
					if(component.getComponentId().equals(slaveId)){
						for(ISAFePort port:component.getServices().getActionPorts()){
							if(port.getId().equals(slavePortId))
								res.add((ISAFeTaskPort)port);
						}
					}
				}
			}
		}
		return res;
	}
	
	@Override
	public void setApplication(SAFeApplication safeApplication) {
		this.safeApplication = safeApplication;
	}

	@Override
	public ISAFeComponent getParent() {
		return null;
	}

	@Override
	public ISAFePort lookUpServicePort(String usesId, String portId) {
		return findProviderServiceSAFePortFromUsesPort(usesId, portId);
	}

	@Override
	public List<ISAFeTaskPort> lookUpActionPort(String masterId, String portId) {
		return findProviderActionSAFePortFromMasterPort(masterId, portId);
	}

	

	
}
