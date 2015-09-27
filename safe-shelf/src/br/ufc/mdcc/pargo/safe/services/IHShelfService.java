package br.ufc.mdcc.pargo.safe.services;

import br.ufc.mdcc.pargo.safe.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.HShelfFramework;
import br.ufc.mdcc.pargo.safe.port.HShelfPort;
import br.ufc.mdcc.pargo.safe.port.HShelfProvidesPort;
import br.ufc.mdcc.pargo.safe.port.HShelfUsesPort;

public interface IHShelfService {

	public void initialize(HShelfFramework framework, HShelfComponent component);
	public HShelfProvidesPort getProvidesPort(String name);
	public void  setProvidesPort(HShelfProvidesPort port);
	public void registerUsesPort(HShelfUsesPort port);
	 
}
