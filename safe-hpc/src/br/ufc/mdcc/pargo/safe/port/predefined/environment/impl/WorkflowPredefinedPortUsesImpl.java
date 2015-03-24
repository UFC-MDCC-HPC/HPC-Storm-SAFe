package br.ufc.mdcc.pargo.safe.port.predefined.environment.impl;

import br.ufc.mdcc.pargo.safe.framework.HPCStormSAFeSWL;
import br.ufc.mdcc.pargo.safe.port.annotations.UsesProvidesAnnotation;
import br.ufc.mdcc.pargo.safe.port.predefined.environment.WorkflowPredefinedPortUses;
import br.ufc.mdcc.pargo.safe.util.SAFeConsoleLogger;

public class WorkflowPredefinedPortUsesImpl extends WorkflowPredefinedPortUses{

	private String name;
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	@UsesProvidesAnnotation(key=1)
	public void usesSAFeSWL(HPCStormSAFeSWL safeSWL) {
		SAFeConsoleLogger.write("Receiving SAFESWL...");
		
	}

}
