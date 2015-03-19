package br.ufc.mdcc.pargo.safe.port.predefined;

import br.ufc.mdcc.pargo.safe.framework.HPCStormSAFeSWL;
import br.ufc.mdcc.pargo.safe.grammar.SAFeSWLParser;
import br.ufc.mdcc.pargo.safe.port.IHPCStormPort;

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

	@Override
	public HPCStormSAFeSWL providesSAFeSWL() {
		//the SAFeSWL is provided in its default way...an empty object.
		return new HPCStormSAFeSWL();
	}

}
