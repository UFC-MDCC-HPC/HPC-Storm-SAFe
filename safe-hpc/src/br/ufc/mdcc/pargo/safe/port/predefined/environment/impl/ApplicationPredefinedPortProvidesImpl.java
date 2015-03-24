package br.ufc.mdcc.pargo.safe.port.predefined.environment.impl;

import br.ufc.mdcc.pargo.safe.framework.HPCStormSAFeSWL;
import br.ufc.mdcc.pargo.safe.port.annotations.UsesProvidesAnnotation;
import br.ufc.mdcc.pargo.safe.port.predefined.environment.ApplicationPredefinedPortProvides;
import br.ufc.mdcc.pargo.safe.util.SAFeConsoleLogger;

public class ApplicationPredefinedPortProvidesImpl extends ApplicationPredefinedPortProvides{

	private String name;
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	@UsesProvidesAnnotation(key=1)
	public HPCStormSAFeSWL providesSAFeSWL() {
		SAFeConsoleLogger.write("Sending SAFESWL...");
		HPCStormSAFeSWL safe = new HPCStormSAFeSWL();
		return safe;
	}

}
