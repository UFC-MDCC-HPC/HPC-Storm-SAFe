package br.ufc.mdcc.pargo.safe.service;


import java.util.HashMap;
import java.util.Map;

import br.ufc.mdcc.pargo.safe.port.HPCStormEnvProvidesPort;
import br.ufc.mdcc.pargo.safe.port.HPCStormEnvUsesPort;
import br.ufc.mdcc.pargo.safe.port.IHPCStormTaskPort;



/**
 * First Services implementation. 
 * @author jefferson
 *
 */
public class HPCStormServicesImpl implements IHPCStormServices{

	private Map<String, HPCStormEnvUsesPort> envUsesMap;
	private Map<String, HPCStormEnvProvidesPort> envProvMap;
	private Map<String, IHPCStormTaskPort> taskMap;
	
	public HPCStormServicesImpl() {
		this.envUsesMap = new HashMap<String,HPCStormEnvUsesPort>();
		this.envProvMap = new HashMap<String,HPCStormEnvProvidesPort>();
		this.taskMap = new HashMap<String,IHPCStormTaskPort>();
	}
	
	@Override
	public HPCStormEnvUsesPort getUsesPort(String id) {
		
		return this.envUsesMap.get(id);
	}

	@Override
	public HPCStormEnvProvidesPort getProvidesPort(String id) {
		
		return this.envProvMap.get(id);
	}

	@Override
	public void registerUsesPort(HPCStormEnvUsesPort uses) {
		this.envUsesMap.put(uses.getId(), uses);
	}

	@Override
	public void registerProvidesPort(HPCStormEnvProvidesPort provides) {
		this.envProvMap.put(provides.getId(), provides);
	}

	@Override
	public IHPCStormTaskPort getTaskPort(String id) {
		return this.taskMap.get(id);
	}

	@Override
	public void registerTaskPort(IHPCStormTaskPort taskPort) {
		this.taskMap.put(taskPort.getId(), taskPort);		
	}

	
}