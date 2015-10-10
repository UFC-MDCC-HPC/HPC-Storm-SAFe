package br.ufc.mdcc.pargo.safe.framework.port;

import java.util.List;

import br.ufc.mdcc.pargo.safe.framework.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;

public abstract class HShelfBuilderService extends HShelfPort {

	public abstract HShelfComponent createComponent(String instanceName,
			String className) throws HShelfException;
	public abstract HShelfComponent getComponent(String isntanceName) throws HShelfException;;
	public abstract List<HShelfComponent> getComponents();
	public abstract List<HShelfPort> getProvidesPortList();
	public abstract List<HShelfPort> getTaskPortList();
	
}
