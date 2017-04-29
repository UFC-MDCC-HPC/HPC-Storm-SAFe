package br.ufc.mdcc.pargo.safe.v6.impl;

import java.util.ArrayList;
import java.util.List;

import br.ufc.mdcc.pargo.safe.v6.ISAFeActionConnection;
import br.ufc.mdcc.pargo.safe.v6.ISAFeAbstractFramework;
import br.ufc.mdcc.pargo.safe.v6.ISAFeBuilderServicePort;
import br.ufc.mdcc.pargo.safe.v6.ISAFeComponent;
import br.ufc.mdcc.pargo.safe.v6.ISAFeServices;
import br.ufc.mdcc.pargo.safe.v6.ISAFeServiceConnection;

public class SAFeFramework implements ISAFeBuilderServicePort,ISAFeAbstractFramework{

	private List<ISAFeActionConnection> actionConnections;
	private List<ISAFeServiceConnection> serviceConnections;
	
	public SAFeFramework() {
		this.serviceConnections = new ArrayList<ISAFeServiceConnection>();
		this.actionConnections = new ArrayList<ISAFeActionConnection>();
	}
	
	@Override
	public ISAFeServices getServices() {
		return new SAFeServices();
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
			String masterActionId, List<String> slaveListIds,
			String slaveActionId) {
		
		ISAFeActionConnection connection = new SAFeConnection();
		connection.initializeActionConnection(slaveActionPortId, masterActionPortId, slaveComponentId, masterComponentId);
		return null;
	}

	@Override
	public List<String> getComponentIds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getUsePortIds(String usesId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getProviderPortIds(String providerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getActionPorts(String componentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ISAFeComponent getComponent(String componentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ISAFeServiceConnection> getServiceConnections(String componentId) {
		// TODO Auto-generated method stub
		return null;
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

}
