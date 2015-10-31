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
	
	public void sendMessage(String message){
		try {
			HShelfApplicationBidingServerWSService service = new HShelfApplicationBidingServerWSService(new URL(location));
			IHShelfApplicationBidingServerWS port = service.getHShelfApplicationBidingServerWSPort();
			port.service(message);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
