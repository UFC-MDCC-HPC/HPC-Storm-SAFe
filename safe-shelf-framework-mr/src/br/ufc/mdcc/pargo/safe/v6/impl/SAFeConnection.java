package br.ufc.mdcc.pargo.safe.v6.impl;

import br.ufc.mdcc.pargo.safe.v6.ISAFeActionConnection;
import br.ufc.mdcc.pargo.safe.v6.ISAFeServiceConnection;

public class SAFeConnection implements ISAFeActionConnection,ISAFeServiceConnection{
	
	//service
	private String providerPortId;
	private String userPortId;
	private String providerComponentId;
	private String userComponentId;
	//action
	private String masterComponentId;
	private String slaveComponentId;
	private String masterActionPortId;
	private String slaveActionPortId;

	
	public void initializeServiceConnection(String providerPortId, 
			String userPortId,
			String providerComponentId,
			String userComponentId){
		
		this.providerPortId = providerPortId;
		this.userPortId = userPortId;
		this.providerComponentId = providerComponentId;
		this.userComponentId = userComponentId;
	}
	
	public void initializeActionConnection(String slaveActionPortId,
			String  masterActionPortId,
			String slaveComponentId,
			String masterComponentId){
		
		this.masterComponentId = masterComponentId;
		this.slaveComponentId = slaveComponentId;
		this.masterActionPortId = masterActionPortId;
		this.slaveActionPortId = slaveActionPortId;
	}

	@Override
	public String getProviderComponentId() {
		return providerComponentId;
	}

	@Override
	public String getUserComponentId() {
		return userComponentId;
	}

	@Override
	public String getProviderPortId() {
		return providerPortId;
	}

	@Override
	public String getUserPortId() {
		return userPortId;
	}

	@Override
	public String getMasterComponentId() {
		return masterComponentId;
	}

	@Override
	public String getSlaveComponentId() {
		return slaveComponentId;
	}

	@Override
	public String getMasterActionPortId() {
		return masterActionPortId;
	}

	@Override
	public String getSlaveActionPortId() {
		return slaveActionPortId;
	}

}
