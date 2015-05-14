package br.ufc.mdcc.pargo.safe.port.predef;

import javax.jws.WebService;

import br.ufc.mdcc.pargo.safe.port.IHPCStormEnvProvidesPort;
/**
 * This port belong to the application. 
 * @author jefferson
 *
 */
@WebService(endpointInterface="br.ufc.mdcc.pargo.safe.port.predef.ISAFeSWLPort")
public class SAFeSWLProvidesPort 
	implements ISAFeSWLPort,IHPCStormEnvProvidesPort{

	private String id;
	private String name;
	private String url;
	
	public SAFeSWLProvidesPort() {
		this.id = "00174aaTR";
		this.name = "safeswl_provides";
	}
	
	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getURL() {
		return this.url;
	}

	@Override
	public void setURL(String url) {
		this.url = url;
	}
	
	@Override
	public String getArchXMLLocation() {
		String fileName = "src/br/ufc/mdcc/pargo/safe/grammar/arch_03_example.xml";
		return fileName;
	}

	@Override
	public String getFlowXMLLocation() {
		String fileName = "src/br/ufc/mdcc/pargo/safe/grammar/flow_04_example.xml";
		return fileName;
	}

	

}

/* IMPORTANT!
 * Generate client for this using cmd (run service first!):
 * $SAFE_HOME/src$ wsimport -p br.ufc.mdcc.pargo.safe.port.predef.client.safeswl -keep http://localhost:8888/safeswl_provides?wsdl
 * 
 */
