package br.ufc.mdcc.pargo.safe.v6;

public interface ISAFeServiceConnection {

	public String getProviderComponentId();
	public String getUserComponentId();
	public String getProviderPortId();
	public String getUserPortId();
	public void initializeServiceConnection(String providerPortId, 
			String userPortId,
			String providerComponentId,
			String userComponentId);
	
}
