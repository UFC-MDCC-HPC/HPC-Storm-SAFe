package br.ufc.mdcc.pargo.safe.framework.application.biding;

import javax.jws.WebMethod;
import javax.jws.WebService;

import br.ufc.mdcc.pargo.safe.framework.application.HShelfApplication;

@WebService
public interface IHShelfApplicationBidingServerWS {
	
	public void setApplication(HShelfApplication application);
	@WebMethod
	public void service(String message);
	
}
