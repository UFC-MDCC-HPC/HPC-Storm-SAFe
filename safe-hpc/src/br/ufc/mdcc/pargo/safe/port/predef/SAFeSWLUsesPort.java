package br.ufc.mdcc.pargo.safe.port.predef;

import br.ufc.mdcc.pargo.safe.port.IHPCStormEnvUsesPort;
import br.ufc.mdcc.pargo.safe.port.predef.client.safeswl.SAFeSWLProvidesPortService;
import br.ufc.mdcc.pargo.safe.util.SAFeConsoleLogger;

public class SAFeSWLUsesPort 
	implements ISAFeSWLPort, IHPCStormEnvUsesPort {

	private String id;
	private String name;
	
	public SAFeSWLUsesPort() {
		this.id = "0s54ww0";
		this.name = "safeswl_uses";
	}
	
	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public String getName() {
		return this.name;
	}

	/**
	 * This method is a client for the same provides operation implemented by the application.
	 * This method connects this port with the provides port. The connection logic must not be here.
	 * @return
	 */
	@Override
	public String getFlowXMLLocation() {
		SAFeSWLProvidesPortService service
			= new SAFeSWLProvidesPortService();
		br.ufc.mdcc.pargo.safe.port.predef.client.safeswl.ISAFeSWLPort port = service.getSAFeSWLProvidesPortPort();
		SAFeConsoleLogger.write("SAFeSWLUsesPort connected");
		return port.getFlowXMLLocation();
	}

	@Override
	public String getArchXMLLocation() {
		SAFeSWLProvidesPortService service
			= new SAFeSWLProvidesPortService();
		br.ufc.mdcc.pargo.safe.port.predef.client.safeswl.ISAFeSWLPort port = service.getSAFeSWLProvidesPortPort();
		SAFeConsoleLogger.write("SAFeSWLUsesPort connected");
		return port.getArchXMLLocation();
	}
	
}


