package br.ufc.mdcc.pargo.safe.port.predef;

import javax.jws.WebMethod;
import javax.jws.WebService;

import br.ufc.mdcc.pargo.safe.port.IHPCStormPort;

@WebService
public interface ISAFeSWLPort extends IHPCStormPort{

	@WebMethod
	public String getArchXMLLocation();
	@WebMethod
	public String getFlowXMLLocation();
	
}
