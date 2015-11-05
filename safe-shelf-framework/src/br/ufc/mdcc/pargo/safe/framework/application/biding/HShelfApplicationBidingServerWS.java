package br.ufc.mdcc.pargo.safe.framework.application.biding;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface="br.ufc.mdcc.pargo.safe.framework.application.biding.IHShelfApplicationBidingServerWS")
public class HShelfApplicationBidingServerWS implements IHShelfApplicationBidingServerWS{

	private HShelfApplicationBidingServerFacade appFacade;
	
	public void setApplicationFacade(HShelfApplicationBidingServerFacade appFacade){
		this.appFacade = appFacade;
	}
	
	@WebMethod
	public void fireEvent(HShelfApplicationBidingEvent event){
		this.appFacade.receiveEventFromWS(event);
	}
}
