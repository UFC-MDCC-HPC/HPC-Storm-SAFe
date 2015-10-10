package br.ufc.mdcc.pargo.safe.framework.services;

import br.ufc.mdcc.pargo.safe.framework.HShelfFramework;
import br.ufc.mdcc.pargo.safe.framework.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfPort;

public interface IHShelfService {

	public void initialize(HShelfFramework framework, HShelfComponent component);
	public HShelfPort getProvidesPort(String name) throws HShelfException;
	public void setProvidesPort(HShelfPort port) throws HShelfException;
	public HShelfPort getTaskPort(String name) throws HShelfException;
	public void setTaskPort(HShelfPort port) throws HShelfException;
}
