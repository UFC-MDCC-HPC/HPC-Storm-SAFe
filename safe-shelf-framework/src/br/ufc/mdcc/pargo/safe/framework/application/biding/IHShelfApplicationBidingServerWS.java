package br.ufc.mdcc.pargo.safe.framework.application.biding;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface IHShelfApplicationBidingServerWS {
	
	public void setApplicationFacade(HShelfApplicationBidingServerFacade appFacade);
	@WebMethod
	public void service(String message);
	
}
