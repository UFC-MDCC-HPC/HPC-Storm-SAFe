package br.ufc.mdcc.pargo.safe.framework.port;

import java.util.List;

import br.ufc.mdcc.pargo.safe.framework.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.workflow.HShelfWorkflow;

public abstract class HShelfBuilderService extends HShelfPort {

	public abstract HShelfComponent createComponent(String instanceName,
			String className) throws HShelfException;
	public abstract HShelfComponent getComponent(String instanceName) throws HShelfException;
	public abstract List<HShelfComponent> getComponents();
	
	public abstract List<HShelfProvidesPort> getProvidesPortList();
	public abstract List<HShelfUsesPort> getUsesPortList();
	public abstract List<HShelfTaskPort> getTaskPortList();
	
	public abstract void connect(String usesPortName, String providesPortName);
	public abstract void connectPartners(String taskA, String taskB);
	public abstract void createWorkflow();
}
