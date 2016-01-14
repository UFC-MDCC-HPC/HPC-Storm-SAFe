package br.ufc.safe.sample.app.prt.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import br.ufc.safe.sample.app.prt.AppRequestMessageEnvPort;

@WebService(endpointInterface="br.ufc.safe.sample.app.prt.service.IAppRequestMessageEnvPortService")
public class AppRequestMessageEnvPortService implements IAppRequestMessageEnvPortService{

	private AppRequestMessageEnvPort appRequestMessageEnvPort;
	
	public AppRequestMessageEnvPortService(AppRequestMessageEnvPort appRequestMessageEnvPort) {
		this.appRequestMessageEnvPort = appRequestMessageEnvPort;
	}
	
	@Override
	@WebMethod
	public void requestMessage() {
		this.appRequestMessageEnvPort.requestMessage();
	}

}
