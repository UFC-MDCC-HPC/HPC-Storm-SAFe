package br.ufc.mdcc.pargo.safe.v6;

public interface ISAFeComponent {
	
	public void setServices(ISAFeServices services);
	public void setComponentId(String componentId);
	public ISAFeServices getServices();
	public String getComponentId();

}
