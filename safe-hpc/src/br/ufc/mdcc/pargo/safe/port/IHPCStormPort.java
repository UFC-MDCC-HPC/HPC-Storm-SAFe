package br.ufc.mdcc.pargo.safe.port;

import br.ufc.mdcc.pargo.safe.component.IHPCStormComponent;

public interface IHPCStormPort<T> {
	
	public String getId();
	public Class<T> getType();
	public String getName();
	public void action(); 
	public boolean isConnected();
	public void setConnected(boolean value);
	public void setComponent(IHPCStormComponent parent);
}
