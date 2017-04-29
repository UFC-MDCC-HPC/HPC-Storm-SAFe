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
	public List<String> getUsePortIds(String usesId);
	public List<String> getProviderPortIds(String providerId);
	public List<String> getActionPorts(String componentId);
	public ISAFeComponent getComponent(String componentId);
	
	public List<ISAFeServiceConnection> getServiceConnections(String componentId);
	public List<ISAFeServiceConnection> getActionConnections(String componentId);

}
