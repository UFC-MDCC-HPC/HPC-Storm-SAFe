package br.ufc.mdcc.pargo.safe.v6;

import java.util.List;

public interface ISAFeBuilderServicePort extends ISAFePort {

	public ISAFeServiceConnection connectService(String userId,
											 String userPortId,
											 String providerId,
											 String providerPortId);

	public ISAFeActionConnection connectAction(String masterId,
										   String masterActionId,
										   String slaveId,
										   String slaveActionId);
	
	public List<String> getComponentIds();
	public List<String> getUsePortIds(String componentId);
	public List<String> getProviderPortIds(String componentId);
	public List<String> getActionPortIdsRegistered(String componentId);
	public List<String> getActionPortIds(String componentId);

	public ISAFeComponent getComponent(String componentId);
	
	public List<ISAFeServiceConnection> getServiceConnections(String componentId);
	public List<ISAFeServiceConnection> getActionConnections(String componentId);

}
