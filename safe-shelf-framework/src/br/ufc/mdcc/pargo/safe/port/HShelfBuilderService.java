package br.ufc.mdcc.pargo.safe.port;

import java.util.List;

import br.ufc.mdcc.pargo.safe.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.HShelfConnection;

public abstract class HShelfBuilderService extends HShelfPort {

	public abstract HShelfConnection connect(HShelfComponent user,
			String userPortName, HShelfComponent providerComponent,
			String providerPortName)  throws HShelfException; 

	public abstract void disconnect(HShelfConnection conn) throws HShelfException;;

	public abstract HShelfComponent createComponent(String instanceName,
			String className) throws HShelfException;
	public abstract HShelfComponent getComponent(String isntanceName) throws HShelfException;;
	public abstract List<HShelfComponent> getComponents();
	public abstract List<HShelfPort> getProvidesPort();
	
	
}
