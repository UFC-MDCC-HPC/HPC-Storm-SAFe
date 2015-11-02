package br.ufc.mdcc.pargo.safe.framework.application.biding;

import java.net.MalformedURLException;
import java.net.URL;

import br.ufc.mdcc.pargo.safe.framework.application.biding.stubs.HShelfApplicationBidingServerWSService;
import br.ufc.mdcc.pargo.safe.framework.application.biding.stubs.IHShelfApplicationBidingServerWS;


public class HShelfApplicationBidingClientFacade {

	private String location;
	
	public void setServerLocation(String location){
		this.location = location;
	}
	
	public void sendEvent(HShelfApplicationBidingEvent event){
		
		br.ufc.mdcc.pargo.safe.framework.application.biding.stubs.HShelfApplicationBidingEvent eventStub = null;
		eventStub = new br.ufc.mdcc.pargo.safe.framework.application.biding.stubs.HShelfApplicationBidingEvent();
		eventStub.setEventType(event.getEventType());
		eventStub.setValue(event.getValue());
		try {
			HShelfApplicationBidingServerWSService service = new HShelfApplicationBidingServerWSService(new URL(location));
			IHShelfApplicationBidingServerWS port = service.getHShelfApplicationBidingServerWSPort();
			port.fireEvent(eventStub);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
