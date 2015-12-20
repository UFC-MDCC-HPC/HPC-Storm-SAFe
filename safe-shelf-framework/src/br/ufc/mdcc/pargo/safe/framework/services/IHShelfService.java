package br.ufc.mdcc.pargo.safe.framework.services;

import br.ufc.mdcc.pargo.safe.framework.HShelfFramework;
import br.ufc.mdcc.pargo.safe.framework.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfProvidesPort;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfTaskPort;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfUsesPort;

public interface IHShelfService {

	public void initialize(HShelfFramework framework, HShelfComponent component);
	
	public HShelfUsesPort getProvidesPort(String usesPortName) throws HShelfException; //that's strange...
	public void setProvidesPort(HShelfProvidesPort port) throws HShelfException;
	
	public HShelfTaskPort getTaskPort(String name) throws HShelfException;
	public void setTaskPort(HShelfTaskPort port) throws HShelfException;
	
	public void registerUsesPort(HShelfUsesPort port) throws HShelfException;
}
