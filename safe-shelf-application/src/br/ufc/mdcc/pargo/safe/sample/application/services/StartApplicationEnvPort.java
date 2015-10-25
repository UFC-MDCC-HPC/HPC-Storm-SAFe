package br.ufc.mdcc.pargo.safe.sample.application.services;

import javax.xml.ws.Endpoint;

import br.ufc.mdcc.pargo.safe.sample.application.ClientServerApplication;

public class StartApplicationEnvPort {

	public void start(ClientServerApplication application){
	
		IApplicationEnvPort appPort = new ApplicationEnvPortImpl(application);
		String urlAppPort = "http://localhost:10010/app-port";
		Endpoint.publish(urlAppPort, appPort);
		System.out.println(urlAppPort);
		
	}
}
