package br.ufc.mdcc.pargo.safe.port.dflt;

import java.util.List;

import br.ufc.mdcc.pargo.safe.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.HShelfConnection;
import br.ufc.mdcc.pargo.safe.port.HShelfPort;
import br.ufc.mdcc.pargo.safe.port.HShelfProvidesPort;
import br.ufc.mdcc.pargo.safe.port.HShelfUsesPort;

public abstract class HShelfBuilderService extends HShelfPort {

	public abstract HShelfConnection connect(HShelfComponent user,
			String userPortName, HShelfComponent providerComponent,
			String providerPortName);

	public abstract void disconnect(HShelfConnection conn);

	public abstract HShelfComponent createComponent(String instanceName,
			String className);
	public abstract HShelfComponent getComponent(String isntanceName);
	public abstract List<HShelfComponent> getComponents();
	public abstract List<HShelfProvidesPort> getProvidesPort();
	public abstract List<HShelfUsesPort> getUsesPort();
	
}
