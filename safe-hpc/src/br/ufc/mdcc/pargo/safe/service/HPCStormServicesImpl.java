package br.ufc.mdcc.pargo.safe.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.ufc.mdcc.pargo.safe.port.IHPCStormProvides;
import br.ufc.mdcc.pargo.safe.port.IHPCStormUses;

/**
 * First Services implementation. 
 * @author jefferson
 *
 */
public class HPCStormServicesImpl 
implements IHPCStormServices{

	private Map<String,IHPCStormUses<?>> usesPorts;
	private Map<String,IHPCStormProvides<?>> providesPorts;
	
	public HPCStormServicesImpl() {
		this.usesPorts = new HashMap<String,IHPCStormUses<?>>();
		this.providesPorts = new HashMap<String,IHPCStormProvides<?>>();
	}
	
	@Override
	public IHPCStormUses<?> getUsesPort(String id) {
		return this.usesPorts.get(id);
	}
	
	@Override
	public IHPCStormProvides<?> getProvidesPort(String id) {
		return this.providesPorts.get(id);
	}

	@Override
	public void setProvidesPort(IHPCStormProvides<?> provides) {
		this.providesPorts.put(provides.getId(),provides);
	}

	@Override
	public void registerUsesPort(IHPCStormUses<?> uses) {
		this.usesPorts.put(uses.getId(),uses);		
	}
	
	public List<String> listAllPortIds(){
		List<String> ids = new ArrayList<String>();
		ids.addAll(providesPorts.keySet());
		ids.addAll(usesPorts.keySet());
		return ids;
	}

}
