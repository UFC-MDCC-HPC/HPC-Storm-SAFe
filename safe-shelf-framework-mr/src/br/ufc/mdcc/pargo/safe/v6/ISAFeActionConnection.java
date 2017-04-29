package br.ufc.mdcc.pargo.safe.v6;


public interface ISAFeActionConnection {

	public String getMasterComponentId();
	public String getSlaveComponentId();
	
	public String getMasterActionPortId();
	public String getSlaveActionPortId();
	

	public void initializeActionConnection(String slaveActionPortId,
			String  masterActionPortId,
			String slaveComponentId,
			String masterComponentId);
}
