package br.ufc.mdcc.pargo.safe.port.predef;

import javax.jws.WebService;

import br.ufc.mdcc.pargo.safe.port.IHPCStormEnvProvidesPort;

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
	public String getXMLLocation() {
		String fileName = "src/br/ufc/mdcc/pargo/safe/grammar/flow_02_example.xml";
		return fileName;
	}

	

}
