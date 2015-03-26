package br.ufc.mdcc.pargo.safe.service;

import br.ufc.mdcc.pargo.safe.port.IHPCStormProvides;
import br.ufc.mdcc.pargo.safe.port.IHPCStormUses;

public interface IHPCStormServices{

	//port registering...
	public IHPCStormUses getUsesPort(String id);
	public void setProvidesPort(IHPCStormProvides provides);
	public void registerUsesPort(IHPCStormUses uses);
	
}
