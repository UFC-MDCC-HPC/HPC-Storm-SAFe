package br.ufc.mdcc.pargo.safe.service;

import java.util.ArrayList;
import java.util.List;

import br.ufc.mdcc.pargo.safe.port.IHPCStormProvides;
import br.ufc.mdcc.pargo.safe.port.IHPCStormUses;

/**
 * First Services implementation. 
 * @author jefferson
 *
 */
public class HPCStormServicesImpl 
implements IHPCStormServices{

	private List<IHPCStormUses> usesPorts;
	private List<IHPCStormProvides> providesPorts;
	
	public HPCStormServicesImpl() {
		this.usesPorts = new ArrayList<IHPCStormUses>();
		this.providesPorts = new ArrayList<IHPCStormProvides>();
	}
	
	@Override
	public IHPCStormUses getUsesPort(String id) {
		return null;
	}

	@Override
	public void setProvidesPort(IHPCStormProvides provides) {
		this.providesPorts.add(provides);
		
	}

	@Override
	public void registerUsesPort(IHPCStormUses uses) {
		this.usesPorts.add(uses);		
	}
	
	 

}
