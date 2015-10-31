package br.ufc.mdcc.pargo.safe.framework.application.biding;

import javax.xml.ws.Endpoint;

import br.ufc.mdcc.pargo.safe.framework.application.HShelfApplication;

public class HShelfApplicationBidingServerFacade {

	private IHShelfApplicationBidingServerWS server;
	
	public HShelfApplicationBidingServerFacade() {
		this.server = new HShelfApplicationBidingServerWS();
	}
	
	public void setApplication(HShelfApplication application){
		this.server.setApplication(application);
	}
	
	public void startServer(){
	
		String urlAppPort = "http://localhost:10011/app-env";
		Endpoint.publish(urlAppPort, this.server);
		System.out.println(urlAppPort);
	}
	
}
