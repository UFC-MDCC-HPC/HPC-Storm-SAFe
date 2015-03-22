package br.ufc.mdcc.pargo.safe.services;

import java.util.ArrayList;
import java.util.List;

import br.ufc.mdcc.pargo.safe.port.IHPCStormPort;

/**
 * First Services implementation. 
 * @author jefferson
 *
 */
public class HPCStormServicesImpl 
implements IHPCStormServices{

	private List<IHPCStormPort> usesPorts;
	private List<IHPCStormPort> providesPorts;
	
	public HPCStormServicesImpl() {
		this.usesPorts = new ArrayList<IHPCStormPort>();
		this.providesPorts = new ArrayList<IHPCStormPort>();
	}
	
	@Override
	public IHPCStormPort getUsesPort(IHPCStormPort uses) {
		return null;
	}

	@Override
	public void setProvidesPort(IHPCStormPort provides) {
		this.providesPorts.add(provides);
		
	}

	@Override
	public void registerUsesPort(IHPCStormPort uses) {
		this.usesPorts.add(uses);		
	}
	
	 

}
