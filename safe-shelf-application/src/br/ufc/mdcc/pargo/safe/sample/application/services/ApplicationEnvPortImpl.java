package br.ufc.mdcc.pargo.safe.sample.application.services;

import javax.jws.WebMethod;
import javax.jws.WebService;

import br.ufc.mdcc.pargo.safe.sample.application.ClientServerApplicationTaskEnv;

@WebService(endpointInterface="br.ufc.mdcc.pargo.safe.sample.application.services.IApplicationEnvPort")
public class ApplicationEnvPortImpl implements IApplicationEnvPort{

	private ClientServerApplicationTaskEnv application;
	
	public ApplicationEnvPortImpl(ClientServerApplicationTaskEnv application) {
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
