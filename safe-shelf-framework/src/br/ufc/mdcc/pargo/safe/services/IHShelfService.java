package br.ufc.mdcc.pargo.safe.services;

import br.ufc.mdcc.pargo.safe.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.HShelfFramework;
import br.ufc.mdcc.pargo.safe.port.HShelfPort;

public interface IHShelfService {

	public void initialize(HShelfFramework framework, HShelfComponent component);
	public boolean notifySemaphoreRelease(String name);
	
	//shelf methods
	public HShelfPort getProvidesPort(String name) throws HShelfException;
	public void  setProvidesPort(HShelfPort port) throws HShelfException;
	
	//cca methods
	public void addProvidesPort(HShelfPort port) throws HShelfException;
	public void registerUsesPort(String name, Object type);
	public HShelfPort getPort(String name);
	 
}
