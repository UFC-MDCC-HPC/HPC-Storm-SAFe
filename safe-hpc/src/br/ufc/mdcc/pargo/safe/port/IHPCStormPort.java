package br.ufc.mdcc.pargo.safe.port;

import br.ufc.mdcc.pargo.safe.component.IHPCStormComponent;

public interface IHPCStormPort {
	
	public String getId();
	public String getName(); 
	public boolean isConnected();
	
	public void setConnected(boolean value);
	public void setComponentParent(IHPCStormComponent parent);
	
	public void run();
}
