package br.ufc.mdcc.pargo.safe.service;

import br.ufc.mdcc.pargo.safe.port.IHPCStormEnvProvidesPort;
import br.ufc.mdcc.pargo.safe.port.IHPCStormEnvUsesPort;
import br.ufc.mdcc.pargo.safe.port.IHPCStormTaskPort;

public interface IHPCStormServices{

	
	public IHPCStormEnvUsesPort getUsesPort(String id);
	public IHPCStormEnvProvidesPort getProvidesPort(String id);
	
	public void registerUsesPort(IHPCStormEnvUsesPort uses);
	public void registerProvidesPort(IHPCStormEnvProvidesPort provides);
	
	public IHPCStormTaskPort getTaskPort(String id);
	public void registerTaskPort(IHPCStormTaskPort taskPort);
	
}
