package br.ufc.mdcc.pargo.safe.framework.application.biding;

import javax.jws.WebMethod;
import javax.jws.WebService;

import br.ufc.mdcc.pargo.safe.framework.application.HShelfApplication;

@WebService(endpointInterface="br.ufc.mdcc.pargo.safe.framework.application.biding.IHShelfApplicationBidingServerWS")
public class HShelfApplicationBidingServerWS implements IHShelfApplicationBidingServerWS{

	private HShelfApplication application;
	
	public void setApplication(HShelfApplication application){
		this.application = application;
	}
	
	@WebMethod
	public void service(String message){
		this.application.messageReceivedEvent(message);
	}
}
