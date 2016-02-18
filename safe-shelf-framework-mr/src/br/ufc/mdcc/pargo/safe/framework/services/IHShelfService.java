package br.ufc.mdcc.pargo.safe.framework.services;

import br.ufc.mdcc.pargo.safe.framework.HShelfFramework;
import br.ufc.mdcc.pargo.safe.framework.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfPort;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfProvidesPort;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfTaskPort;

public interface IHShelfService {
	
	public void initialize(HShelfFramework framework, HShelfComponent component);
	
	public void setProvidesPort(HShelfProvidesPort port) throws HShelfException;
	
	public void registerUsesPort(String name, String type) throws HShelfException;
	public void registerTaskPort(HShelfTaskPort port) throws HShelfException;
	
	public HShelfPort getPort(String name) throws HShelfException; 
	public HShelfPort getTaskPort(String name) throws HShelfException;
	
	public void waitPort(String name);
	public boolean testPort(String name);
	
	public void clear();
	
}
