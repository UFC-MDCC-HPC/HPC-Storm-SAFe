package br.ufc.mdcc.pargo.safe.port.predefined;

import br.ufc.mdcc.pargo.safe.framework.HPCStormSAFeSWL;
import br.ufc.mdcc.pargo.safe.port.IHPCStormPort;
import br.ufc.mdcc.pargo.safe.port.annotations.UsesProvidesAnnotation;
import br.ufc.mdcc.pargo.safe.util.SAFeConsoleLogger;

public class WorkflowPredefinedPortImpl implements IWorkflowPredefinedPort{

	private String type;
	private String name;
	
	public WorkflowPredefinedPortImpl(String name) {
		this.type = IHPCStormPort.uses;
		this.name = name;
	}
	
	@Override
	public String getType() {
		return this.type;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	@UsesProvidesAnnotation(key=1)
	public void usesSAFeSWL(HPCStormSAFeSWL safeSWL) {

		SAFeConsoleLogger.write("Using safeSWL object...");
	}

}
