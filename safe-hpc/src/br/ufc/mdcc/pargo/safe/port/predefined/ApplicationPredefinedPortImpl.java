package br.ufc.mdcc.pargo.safe.port.predefined;

import br.ufc.mdcc.pargo.safe.framework.HPCStormSAFeSWL;
import br.ufc.mdcc.pargo.safe.grammar.SAFeSWLParser;
import br.ufc.mdcc.pargo.safe.port.IHPCStormPort;
import br.ufc.mdcc.pargo.safe.port.annotations.UsesProvidesAnnotation;
import br.ufc.mdcc.pargo.safe.util.SAFeConsoleLogger;

public class ApplicationPredefinedPortImpl implements IApplicationPredefinedPort{

	private String type;
	private String name;

	
	public ApplicationPredefinedPortImpl(String name) {
		this.type = IHPCStormPort.provides;
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

	/**
	 * This is the default implementation: returns an empty object. Appplication developers
	 * should overwrite this method and initialize SAFeSWL in other way.  
	 */
	@Override
	@UsesProvidesAnnotation(key=1)
	public HPCStormSAFeSWL providesSAFeSWL() {
		//the SAFeSWL is provided in its default way...an empty object.
		SAFeConsoleLogger.write("Creating safeSWL object...");
		return new HPCStormSAFeSWL();
	}

}
