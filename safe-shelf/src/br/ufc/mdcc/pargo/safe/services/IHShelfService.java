package br.ufc.mdcc.pargo.safe.services;

import br.ufc.mdcc.pargo.safe.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.HShelfFramework;
import br.ufc.mdcc.pargo.safe.port.HShelfProvidesPort;
import br.ufc.mdcc.pargo.safe.port.HShelfUsesPort;

public interface IHShelfService {

	public void initialize(HShelfFramework framework, HShelfComponent component);
	public HShelfProvidesPort getProvidesPort(String name) throws HShelfException;;
	public void  setProvidesPort(HShelfProvidesPort port) throws HShelfException;;
	public void registerUsesPort(HShelfUsesPort port) throws HShelfException;;
	 
}
