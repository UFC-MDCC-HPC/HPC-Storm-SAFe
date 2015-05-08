package br.ufc.mdcc.pargo.safe.service;

import br.ufc.mdcc.pargo.safe.port.HPCStormEnvProvidesPort;
import br.ufc.mdcc.pargo.safe.port.HPCStormEnvUsesPort;
import br.ufc.mdcc.pargo.safe.port.IHPCStormTaskPort;

public interface IHPCStormServices{

	
	public HPCStormEnvUsesPort getUsesPort(String id);
	public HPCStormEnvProvidesPort getProvidesPort(String id);
	
	public void registerUsesPort(HPCStormEnvUsesPort uses);
	public void registerProvidesPort(HPCStormEnvProvidesPort provides);
	
	public IHPCStormTaskPort getTaskPort(String id);
	public void registerTaskPort(IHPCStormTaskPort taskPort);
	
}
