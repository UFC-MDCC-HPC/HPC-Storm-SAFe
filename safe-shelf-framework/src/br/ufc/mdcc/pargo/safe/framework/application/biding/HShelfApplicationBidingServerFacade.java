package br.ufc.mdcc.pargo.safe.framework.application.biding;

import javax.xml.ws.Endpoint;

public class HShelfApplicationBidingServerFacade {

	private IHShelfApplicationBidingServerWS server;
	private IHShelfApplicationBidingServerFacadeListener listener;
	
	public HShelfApplicationBidingServerFacade() {
		this.server = new HShelfApplicationBidingServerWS();
		this.server.setApplicationFacade(this);
	}
	
	public void registerListener(IHShelfApplicationBidingServerFacadeListener listener){
		this.listener = listener;
	}
	
	public void receiveEventFromWS(HShelfApplicationBidingEvent event){
		this.listener.listenEvent(event);
	}
	
	public void startServer(){
	
		String urlAppPort = "http://localhost:10011/app-env";
		Endpoint.publish(urlAppPort, this.server);
		System.out.println(urlAppPort);
	}
	
}
