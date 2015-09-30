package br.ufc.mdcc.pargo.safe.services;

import br.ufc.mdcc.pargo.safe.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.HShelfFramework;
import br.ufc.mdcc.pargo.safe.port.HShelfPort;

public interface IHShelfService {

	public void initialize(HShelfFramework framework, HShelfComponent component);
	
	//shelf methods (based on CCA)
	public HShelfPort getProvidesPort(String name) throws HShelfException;
	public void  setProvidesPort(HShelfPort port) throws HShelfException;
	 
}
