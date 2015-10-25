package br.ufc.mdcc.pargo.safe.sample.application.services;

import javax.jws.WebMethod;
import javax.jws.WebService;

import br.ufc.mdcc.pargo.safe.sample.application.ClientServerApplication;

@WebService(endpointInterface="br.ufc.mdcc.pargo.safe.sample.application.services.IApplicationEnvPort")
public class ApplicationEnvPortImpl implements IApplicationEnvPort{

	private ClientServerApplication application;
	
	public ApplicationEnvPortImpl(ClientServerApplication application) {
		this.application = application;
	}
	
	@WebMethod 
	public void requestMessage() {
		this.application.requestMessage();
		
	}

	@WebMethod
	public void receiveMessage(String message) {
		this.application.receiveMessage(message);
	}

	 

}
